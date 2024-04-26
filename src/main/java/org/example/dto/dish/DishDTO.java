package org.example.dto.dish;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Setter;

import java.util.Set;


@ApiModel(description = "DTO for Dish entity")
public record DishDTO (
    @ApiModelProperty(notes = "Unique id of the dish")
     Long id,

    @ApiModelProperty(notes = "Name of the dish", required = true)
    @NotBlank
     String name,

    @ApiModelProperty(notes = "Price of the dish", required = true)
    @NotNull
    Double price,

    @ApiModelProperty(notes = "Set of ingredients in the dish")
    Set<IngredientDTO> ingredients,

    @ApiModelProperty(notes = "Menu section to which the dish belongs")
    MenuSectionDTO menuSection
) {}
