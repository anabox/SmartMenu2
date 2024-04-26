package org.example.mapper.dish;
import org.example.dto.dish.MenuSectionDTO;
import org.example.entity.dish.MenuSection;
import org.mapstruct.Mapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Mapper
public interface MenuSectionMapper {
    @ApiModelProperty(notes = "Map MenuSection entity to MenuSectionDTO")
    MenuSectionDTO menuSectionToDto(MenuSection menuSection);

    @ApiModelProperty(notes = "Map MenuSectionDTO to MenuSection entity")
    MenuSection dtoToMenuSection(MenuSectionDTO dto);
}
