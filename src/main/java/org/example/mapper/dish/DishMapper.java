package org.example.mapper.dish;

import org.example.dto.dish.DishDTO;
import org.example.entity.dish.Dish;
import org.mapstruct.Mapper;
import io.swagger.annotations.ApiModelProperty;
import org.mapstruct.factory.Mappers;


import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface DishMapper {
    DishMapper INSTANCE = Mappers.getMapper(DishMapper.class);
    @ApiModelProperty(notes = "Map Dish entity to DishDTO")
    DishDTO dishToDto(Dish dish);
    @ApiModelProperty(notes = "Map DishDTO to Dish entity")
    Dish dtoToDish(DishDTO dto);
    @ApiModelProperty(notes = "Map dishes entities to dish DTOs")
    List<DishDTO> dishesToDtos(List<Dish> dishes);
    @ApiModelProperty(notes = "Map dish DTOs to dish entities")
    Set<Dish> dtosToDishes(Set<DishDTO> dishes);
}
