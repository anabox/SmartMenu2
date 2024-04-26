package org.example.entity.dish;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.extra.StopList;

import java.time.Duration;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"ingredients","stop_lists"})
@ToString(exclude = {"ingredients","stop_lists"})
@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;
    @Column(name = "name",unique = true, nullable = false)
    private  String name;
    @Column(name = "price")
    private  Double price;

    @ManyToMany (cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "dishes_ingredients",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private MenuSection menuSection;

    @ManyToMany(mappedBy = "dishes")
    private Set<StopList> stopLists;

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
        ingredient.getDishes().add(this);
    }
    public void removeIngredient(Ingredient ingredient){
        this.ingredients.remove(ingredient);
        ingredient.getDishes().remove(this);
    }
}
