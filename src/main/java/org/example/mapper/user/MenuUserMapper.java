package org.example.mapper.user;

import io.swagger.annotations.ApiModelProperty;
import org.example.dto.user.MenuUserDTO;
import org.example.entity.user.MenuUser;
import org.mapstruct.Mapper;

@Mapper
public interface MenuUserMapper {
    @ApiModelProperty(notes = "Map MenuUser entity to MenuUserDTO")
    MenuUserDTO menuUserToDto(MenuUser menuUser);

    @ApiModelProperty(notes = "Map MenuUserDTO to MenuUser entity")
    MenuUser dtoToMenuUser(MenuUserDTO dto);
}
