package org.example.repositories.dish;

import org.example.entity.dish.Ingredient;
import org.example.entity.dish.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Long> {
}
