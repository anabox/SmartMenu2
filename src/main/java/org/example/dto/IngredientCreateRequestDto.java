package org.example.dto;

import java.time.Duration;

public record IngredientCreateRequestDto(String name, int nutrition, Duration cookingTime, int price){

}
