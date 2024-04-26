package org.example.service;


import org.example.dto.dish.OrderDTO;
import org.example.entity.dish.Dish;
import org.example.entity.dish.Order;
import org.example.entity.dish.OrderDetails;
import org.example.exception.OrderNotFoundException;
import org.example.mapper.dish.OrderDetailsMapper;
import org.example.mapper.dish.OrderMapper;
import org.example.mapper.user.UserWaiterMapper;
import org.example.repositories.dish.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailsMapper orderDetailsMapper;
    @Autowired
    private UserWaiterMapper userWaiterMapper;


    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(orderMapper::orderToDto).collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found"));
        return orderMapper.orderToDto(order);
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.dtoToOrder(orderDTO);
        List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
        double totalSum = 0.0;
        for (OrderDetails orderDetails : orderDetailsList) {
            Dish dish = orderDetails.getDish();
            double dishPrice = dish.getPrice();
            totalSum += dishPrice * orderDetails.getAmount();
        }

        order.setSum(totalSum);
        order = orderRepository.save(order);
        return orderMapper.orderToDto(order);
    }

    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found"));
        order.setOrderDateTime(orderDTO.orderDateTime());
        order.setTableNum(orderDTO.tableNum());
        order.setUserWaiter(userWaiterMapper.dtoToUserWaiter(orderDTO.userWaiter()));
        order.setOrderDetailsList(orderDetailsMapper.dtosToOrderDetailsList(orderDTO.orderDetailsDtoList()));
        List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
        double totalSum = 0.0;
        for (OrderDetails orderDetails : orderDetailsList) {
            Dish dish = orderDetails.getDish();
            double dishPrice = dish.getPrice();
            totalSum += dishPrice * orderDetails.getAmount();
        }
        order.setSum(totalSum);
        order = orderRepository.save(order);
        return orderMapper.orderToDto(order);
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException("Order not found");
        }
        orderRepository.deleteById(id);
    }
}
