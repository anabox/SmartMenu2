package org.example.repositories.dish;

import org.example.entity.dish.Dish;
import org.example.entity.dish.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
