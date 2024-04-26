package org.example.service;

import org.example.dto.dish.IngredientDTO;
import org.example.entity.dish.Dish;
import org.example.entity.dish.Ingredient;
import org.example.exception.DishNotFoundException;
import org.example.exception.InsufficientIngredientsException;
import org.example.mapper.dish.DishMapper;
import org.example.mapper.dish.IngredientMapper;
import org.example.mapper.dish.MenuSectionMapper;
import org.example.repositories.dish.DishRepository;
import org.example.repositories.dish.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.dto.dish.DishDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private IngredientMapper ingredientMapper;
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private MenuSectionMapper menuSectionMapper;


    public List<DishDTO> getAllDishes() {
        List<Dish> dishes = dishRepository.findAll();
        return DishMapper.INSTANCE.dishesToDtos(dishes);
    }

    public DishDTO createDish(DishDTO dishDTO) {
        Dish dish = DishMapper.INSTANCE.dtoToDish(dishDTO);
        Dish savedDish = dishRepository.save(dish);
        return DishMapper.INSTANCE.dishToDto(savedDish);
    }

    public DishDTO getDishById(Long dishId) {
        Optional<Dish> optionalDish = dishRepository.findById(dishId);
        return optionalDish.map(DishMapper.INSTANCE::dishToDto).orElse(null);
    }

    public DishDTO updateDish(Long dishId, DishDTO dishDTO) {
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new DishNotFoundException("Dish not found"));
        dish.setName(dishDTO.name());
        dish.setPrice(dishDTO.price());
        dish.setIngredients(ingredientMapper.dtosToIngredientList(dishDTO.ingredients()));
        dish.setMenuSection(menuSectionMapper.dtoToMenuSection(dishDTO.menuSection()));
        dish = dishRepository.save(dish);
        return dishMapper.dishToDto(dish);
    }

    public void deleteDish(Long dishId) {
        dishRepository.deleteById(dishId);
    }
    public List<IngredientDTO> getAllIngredients() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        return ingredients.stream().map(ingredientMapper::ingredientToDto).collect(Collectors.toList());
    }
    public IngredientDTO getIngredientById(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(() -> new InsufficientIngredientsException("Ingredient not found"));
        return ingredientMapper.ingredientToDto(ingredient);
    }
    public IngredientDTO createIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = ingredientMapper.dtoToIngredient(ingredientDTO);
        ingredient = ingredientRepository.save(ingredient);
        return ingredientMapper.ingredientToDto(ingredient);
    }
    public void deleteIngredient(Long id) {
        if (!ingredientRepository.existsById(id)) {
            throw new InsufficientIngredientsException("Ingredient not found");
        }
        ingredientRepository.deleteById(id);
    }
}
