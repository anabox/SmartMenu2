package org.example.dto.dish;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import jakarta.validation.constraints.NotBlank;

@ApiModel(description = "DTO for Ingredient entity")
public record IngredientDTO (
    @ApiModelProperty(notes = "Unique identifier of the ingredient")
    Long id,

    @ApiModelProperty(notes = "Name of the ingredient", required = true)
    @NotBlank
    String name
){}
