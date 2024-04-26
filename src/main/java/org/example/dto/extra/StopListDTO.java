package org.example.dto.extra;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.dto.dish.DishDTO;

import java.time.LocalDate;
import java.util.Set;


@ApiModel(description = "DTO for StopList entity")
public record StopListDTO (
    @ApiModelProperty(notes = "Unique identifier of the stop list")
    Long id,

    @ApiModelProperty(notes = "Date of the stop list", required = true)
    @NotNull
    LocalDate date,

    @ApiModelProperty(notes = "Set of dishes in the stop list")
    Set<DishDTO> dishes
){}
