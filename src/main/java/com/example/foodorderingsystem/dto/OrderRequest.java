package com.example.foodorderingsystem.dto;

import java.util.List;

public record OrderRequest(
		Long customerId,
		Long restaurantId,
		List<OrderItemRequest> items) {
}
