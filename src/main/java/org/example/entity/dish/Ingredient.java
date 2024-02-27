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
    @Column(name = "nutrition")
    private  int nutrition;
    @Column(name = "cooking_time")
    private  Duration cookingTime;
    @Column(name = "price")
    private  int price;
    @ManyToMany(mappedBy = "ingredients")
    private Set<Dish> dishes = new HashSet<>();

}
