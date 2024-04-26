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
@Table(name = "menu_sections")
public class MenuSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name",unique = true, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "menuSections")
    private Set<Menu> menus = new HashSet<>();

    @OneToMany(mappedBy = "menuSection", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Dish> dishes = new HashSet<>();

    public void addDish(Dish dish){
        this.dishes.add(dish);
        dish.setMenuSection(this);
    }
    public void removeDish(Dish dish){
        this.dishes.remove(dish);
        dish.setMenuSection(null);
    }

}
