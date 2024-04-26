package org.example.mapper.extra;

import io.swagger.annotations.ApiModelProperty;
import org.example.dto.extra.StopListDTO;
import org.example.entity.extra.StopList;
import org.mapstruct.Mapper;

@Mapper
public interface StopListMapper {
    @ApiModelProperty(notes = "Map StopList entity to StopListDTO")
    StopListDTO stopListToDto(StopList stopList);

    @ApiModelProperty(notes = "Map StopListDTO to StopList entity")
    StopList dtoToStopList(StopListDTO dto);
}
