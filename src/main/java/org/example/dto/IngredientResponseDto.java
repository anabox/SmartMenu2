package org.example.dto;

import java.time.Duration;

public record IngredientResponseDto(long id, String name, int nutrition, Duration cookingTime, int price){

}
