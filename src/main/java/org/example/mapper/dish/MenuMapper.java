package org.example.mapper.dish;
import org.example.dto.dish.MenuDTO;
import org.example.entity.dish.Menu;
import org.mapstruct.Mapper;
import io.swagger.annotations.ApiModelProperty;
@Mapper
public interface MenuMapper {
    @ApiModelProperty(notes = "Map Menu entity to MenuDTO")
    MenuDTO menuToDto(Menu menu);

    @ApiModelProperty(notes = "Map MenuDTO to Menu entity")
    Menu dtoToMenu(MenuDTO dto);
}
