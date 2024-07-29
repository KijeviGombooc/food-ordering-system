package com.example.foodorderingsystem.dto;

import java.util.List;

public record OrderResponse(
	Long id,
	Long customerId,
	List<OrderItemResponse> items
) {
}
