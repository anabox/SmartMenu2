package org.example.entity.dish;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"menuSections"})
@EqualsAndHashCode(exclude = {"menuSections"})
@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;

    @ManyToMany (cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "menus_sections",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "menuSection_id")
    )
    private Set<MenuSection> menuSections =  new HashSet<>();

    public void addMenuSection(MenuSection menuSection){
        this.menuSections.add(menuSection);
        menuSection.getMenus().add(this);
    }
    public void removeMenuSection(MenuSection menuSection){
        this.menuSections.remove(menuSection);
        menuSection.getMenus().remove(this);
    }
}
