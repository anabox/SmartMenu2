package org.example.entity.dish;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"ingredients"})
@ToString(exclude = {"ingredients"})
@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;
    @Column(name = "name")
    private  String name;

    @ManyToMany (cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "dishes_ingredients",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients = new HashSet<>();
    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
        ingredient.getDishes().add(this);
    }
    public void removeIngredient(Ingredient ingredient){
        this.ingredients.remove(ingredient);
        ingredient.getDishes().remove(this);
    }
}
