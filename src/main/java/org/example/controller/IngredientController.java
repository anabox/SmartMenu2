package org.example.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.dto.dish.IngredientDTO;
import org.example.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/ingredients")
@Api(tags = "Ingredient Management")
public class IngredientController {
    @Autowired
    private DishService dishService;

    @GetMapping
    @ApiOperation(value = "Get all ingredients")
    public ResponseEntity<List<IngredientDTO>> getAllIngredients() {
        List<IngredientDTO> ingredients = dishService.getAllIngredients();
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get ingredient by ID")
    public ResponseEntity<IngredientDTO> getIngredientById(@PathVariable Long id) {
        IngredientDTO ingredient = dishService.getIngredientById(id);
        return new ResponseEntity<>(ingredient, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create a new ingredient")
    public ResponseEntity<IngredientDTO> createIngredient(@RequestBody IngredientDTO ingredientDTO) {
        IngredientDTO createdIngredient = dishService.createIngredient(ingredientDTO);
        return new ResponseEntity<>(createdIngredient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete an ingredient")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        dishService.deleteIngredient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
