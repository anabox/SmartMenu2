package org.example.mapper.extra;

import io.swagger.annotations.ApiModelProperty;
import org.example.dto.extra.QuantityDTO;
import org.example.entity.extra.Quantity;
import org.mapstruct.Mapper;

@Mapper
public interface QuantityMapper {
    @ApiModelProperty(notes = "Map Quantity entity to QuantityDTO")
    QuantityDTO quantityToDto(Quantity quantity);

    @ApiModelProperty(notes = "Map QuantityDTO to Quantity entity")
    Quantity dtoToQuantity(QuantityDTO dto);
}
