package com.example.foodorderingsystem.dto;

import java.util.List;

public record OrderResponse(
	Long id,
	Long customerId,
	Long restaurantId,
	OrderStatusDto orderStatus,
	List<OrderItemResponse> items
) {
}
