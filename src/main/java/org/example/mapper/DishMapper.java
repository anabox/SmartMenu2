package org.example.mapper;

import org.example.dto.DishCreateRequestDto;
import org.example.dto.DishResponseDto;
import org.example.dto.IngredientCreateRequestDto;
import org.example.dto.IngredientResponseDto;
import org.example.entity.dish.Dish;
import org.example.entity.dish.Ingredient;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DishMapper {

    public Dish toDish(DishCreateRequestDto dto, Set<Ingredient> ingredients){
        return new Dish(null, dto.name(), ingredients);

    }
    public Ingredient toIngredient(IngredientResponseDto dto){
        return Ingredient.builder()
                .id(dto.id())
                .name(dto.name())
                .nutrition(dto.nutrition())
                .cookingTime(dto.cookingTime())
                .price(dto.price())
                .build();
    }

    public DishResponseDto toDishResponseDto( Dish dish){
        return new DishResponseDto(dish.getId(), dish.getName(), dish.getIngredients().stream()
                .map(this::toIngredientResponseDto).collect(Collectors.toSet()));
    }
    public IngredientResponseDto toIngredientResponseDto(Ingredient ingredient){
       return new IngredientResponseDto(ingredient.getId(),
               ingredient.getName(),
               ingredient.getNutrition(),
               ingredient.getCookingTime(),
               ingredient.getPrice());
    }


}
