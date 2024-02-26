package org.example.dto;

import java.util.Set;

public record DishCreateRequestDto(String name, Set<Long> ingredientIds) {
}
