package com.example.foodorderingsystem.dto;

import java.math.BigDecimal;

public record ItemResponse(
		Long id,
		String name,
		String description,
		BigDecimal price) {
}
