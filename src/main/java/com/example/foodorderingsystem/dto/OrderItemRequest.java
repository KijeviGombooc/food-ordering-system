package com.example.foodorderingsystem.dto;

public record OrderItemRequest(
		Long id,
		Integer quantity,
		String specialInstructions) {
}
