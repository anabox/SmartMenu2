package org.example.mapper.dish;
import org.example.dto.dish.DishDTO;
import org.example.dto.dish.OrderDetailsDTO;
import org.example.entity.dish.Dish;
import org.example.entity.dish.OrderDetails;
import org.mapstruct.Mapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@Mapper
public interface OrderDetailsMapper {
    @ApiModelProperty(notes = "Map OrderDetails entity to OrderDetailsDTO")
    OrderDetailsDTO orderDetailsToDto(OrderDetails orderDetails);

    @ApiModelProperty(notes = "Map OrderDetailsDTO to OrderDetails entity")
    OrderDetails dtoToOrderDetails(OrderDetailsDTO dto);

    @ApiModelProperty(notes = "Map orderDetailsList entities to orderDetailsList DTOs")
    List<OrderDetailsDTO> orderDetailsListToDtos (List<OrderDetails> orderDetailsList);
    @ApiModelProperty(notes = "Map orderDetailsList DTOs to orderDetailsList entities")
    List<OrderDetails> dtosToOrderDetailsList (List<OrderDetailsDTO> orderDetailsDTOList);
}
