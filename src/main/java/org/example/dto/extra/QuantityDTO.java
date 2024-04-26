package org.example.dto.extra;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.dto.dish.IngredientDTO;



@ApiModel(description = "DTO for Quantity entity")
public record QuantityDTO (
    @ApiModelProperty(notes = "Unique identifier of the item in the warehouse")
    Long id,

    @ApiModelProperty(notes = "Ingredient which remained in the warehouse")
    IngredientDTO ingredient,

    @ApiModelProperty(notes = "Amount of the ingredient", required = true)
    @NotNull
    int amount
){}
