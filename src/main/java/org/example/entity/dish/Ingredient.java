package org.example.entity.dish;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"dishes"})
@ToString (exclude = {"dishes"})
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@Table(name = "ingredients")
public final class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;
    @Column(name = "name")
    private  String name;
    @ManyToMany(mappedBy = "ingredients")
    private Set<Dish> dishes = new HashSet<>();

}
