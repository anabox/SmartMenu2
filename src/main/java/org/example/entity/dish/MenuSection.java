package org.example.entity.dish;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"menus"})
@EqualsAndHashCode(exclude = {"menus"})
@Entity
@Table(name = "menuSections",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        })
public class MenuSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "menuSections")
    private Set<Menu> menus = new HashSet<>();

    @ManyToMany (cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "menuSections_dishes",
            joinColumns = @JoinColumn(name = "menuSection_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private Set<Dish> dishes = new HashSet<>();

    public void addDish(Dish dish){
        this.dishes.add(dish);
        dish.getMenuSections().add(this);
    }
    public void removeDish(Dish dish){
        this.dishes.remove(dish);
        dish.getMenuSections().remove(this);
    }

}
