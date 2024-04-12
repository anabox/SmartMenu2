package org.example.entity.extra;

import org.example.entity.dish.Dish;

import java.time.LocalDate;
import java.util.List;

public class StopList {
    private Long id;
    private LocalDate date;
    private List<Dish> dishes;
}
