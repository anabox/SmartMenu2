package org.example.dto.dish;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.Set;

@ApiModel(description = "DTO for MenuSection entity")
public record MenuSectionDTO (
    @ApiModelProperty(notes = "Unique identifier of the menu section")
    Long id,

    @ApiModelProperty(notes = "Name of the menu section", required = true)
    @NotBlank
    String name,

    @ApiModelProperty(notes = "Set of dishes in the menu section")
    Set<DishDTO> dishes
){}
