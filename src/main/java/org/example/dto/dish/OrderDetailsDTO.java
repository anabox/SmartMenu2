package org.example.dto.dish;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@ApiModel(description = "DTO for OrderDetails entity")
public record OrderDetailsDTO (
    @ApiModelProperty(notes = "Unique identifier of the order details")
    Long id,

    @ApiModelProperty(notes = "Dish included in the order details")
    DishDTO dish,

    @ApiModelProperty(notes = "Amount of the dish in the order", required = true)
    @NotNull
    int amount,

    @ApiModelProperty(notes = "Order to which the order details belong")
    OrderDTO order
){}
