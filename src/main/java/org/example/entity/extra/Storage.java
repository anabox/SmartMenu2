package org.example.entity.extra;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.dish.Ingredient;
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"ingredients"})
@ToString(exclude = {"ingredients"})
@Entity
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    private Ingredient ingredient;
    @Column(name = "amount")
    private int amount;
}
