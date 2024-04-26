package org.example.mapper.dish;
import org.example.dto.dish.OrderDTO;
import org.example.entity.dish.Order;
import org.mapstruct.Mapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Mapper
public interface OrderMapper {
    @ApiModelProperty(notes = "Map Order entity to OrderDTO")
    OrderDTO orderToDto(Order order);

    @ApiModelProperty(notes = "Map OrderDTO to Order entity")
    Order dtoToOrder(OrderDTO dto);
}
