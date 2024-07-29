package com.example.foodorderingsystem.dto;

import java.util.List;

public record RestaurantDetailedResponse(
		Long id,
		String name,
		List<ItemResponse> menu) {
}
