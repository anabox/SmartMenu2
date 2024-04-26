package org.example.mapper.user;

import io.swagger.annotations.ApiModelProperty;
import org.example.dto.user.UserWaiterDTO;
import org.example.entity.user.UserWaiter;
import org.mapstruct.Mapper;

@Mapper
public interface UserWaiterMapper {
    @ApiModelProperty(notes = "Map UserWaiter entity to UserWaiterDTO")
    UserWaiterDTO userWaiterToDto(UserWaiter userWaiter);

    @ApiModelProperty(notes = "Map UserWaiterDTO to UserWaiter entity")
    UserWaiter dtoToUserWaiter(UserWaiterDTO dto);
}
