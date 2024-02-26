package org.example.entity.dish;

import java.util.List;


public record Order(List<OrderDetail> orderDetails) {


    public record OrderDetail(Dish dish, Integer amount, String comment) {

    }
}
