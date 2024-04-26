package org.example.entity.extra;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.dish.Dish;
import org.example.entity.dish.Ingredient;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"dishes"})
@ToString(exclude = {"dishes"})
@Entity
@Table(name = "stop_lists")
public class StopList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @ManyToMany (cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "stop_lists_dishes",
            joinColumns = @JoinColumn(name = "stop_list_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private Set<Dish> dishes;

    public void addDish(Dish dish){
        this.dishes.add(dish);
        dish.getStopLists().add(this);
    }
    public void removeDish(Dish dish){
        this.dishes.remove(dish);
        dish.getStopLists().remove(this);
    }

}
