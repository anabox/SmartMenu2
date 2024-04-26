package org.example.dto.dish;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Set;



@ApiModel(description = "DTO for Dish entity")
public record MenuDTO (
    @ApiModelProperty(notes = "Unique identifier of the menu")
    Long id,

    @ApiModelProperty(notes = "Name of the menu", required = true)
    @NotBlank
    String name,

    @ApiModelProperty(notes = "Set of menu sections in the menu")
    Set<MenuSectionDTO> menuSections
){}
