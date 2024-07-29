package com.example.foodorderingsystem.dto;

public record OrderItemResponse(
		Long id,
		Integer quantity,
		String specialInstructions) {
}
