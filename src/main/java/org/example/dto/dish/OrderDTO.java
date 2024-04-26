package org.example.dto.dish;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.dto.user.UserWaiterDTO;


import java.time.LocalDateTime;
import java.util.List;


@ApiModel(description = "DTO for Order entity")
public record OrderDTO (
    @ApiModelProperty(notes = "Unique identifier of the order")
    Long id,

    @ApiModelProperty(notes = "Date and time when the order was placed", required = true)
    @NotNull
    LocalDateTime orderDateTime,

    @ApiModelProperty(notes = "Total sum of the order", required = true)
    double sum,

    @ApiModelProperty(notes = "Table number for the order", required = true)
    int tableNum,

    @ApiModelProperty(notes = "Details of the order")
    List<OrderDetailsDTO> orderDetailsDtoList,

    @ApiModelProperty(notes = "User waiter who took the order")
    UserWaiterDTO userWaiter
){}
