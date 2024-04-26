package org.example.mapper.dish;
import org.example.entity.dish.Ingredient;
import org.mapstruct.Mapper;
import io.swagger.annotations.ApiModelProperty;
import org.example.dto.dish.IngredientDTO;

import java.util.List;
import java.util.Set;

@Mapper
public interface IngredientMapper {
    @ApiModelProperty(notes = "Map Ingredient entity to IngredientDTO")
    IngredientDTO ingredientToDto(Ingredient ingredient);

    @ApiModelProperty(notes = "Map IngredientDTO to Ingredient entity")
    Ingredient dtoToIngredient(IngredientDTO dto);
    @ApiModelProperty(notes = "Map IngredientList entities to IngredientList DTOs")
    List<IngredientDTO> ingredientListToDtos (List<Ingredient> ingredientList);
    @ApiModelProperty(notes = "Map orderDetailsList DTOs to IngredientList entities")
    Set<Ingredient> dtosToIngredientList (Set<IngredientDTO> IngredientDTOList);
}
