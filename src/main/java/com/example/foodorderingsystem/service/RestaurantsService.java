package com.example.foodorderingsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.foodorderingsystem.dto.OrderItemResponse;
import com.example.foodorderingsystem.dto.OrderResponse;
import com.example.foodorderingsystem.dto.OrderStatusRequest;


@Service
public class RestaurantsService {

	public List<OrderResponse> getOrders() {
		// TODO: replace dummy return value
		return List.of(
			new OrderResponse(0l, 0l, List.of(
				new OrderItemResponse(0l, 3, ""),
				new OrderItemResponse(0l, 3, "No onions")
			)),
			new OrderResponse(1l, 1l, List.of(
				new OrderItemResponse(0l, 5, "With onions")
			))
		);
	}

	public void patchOrder(Long id, OrderStatusRequest orderStatusRequest) {
		// TODO: replace dummy return value
	}

	public OrderResponse getOrder(Long id) {
		// TODO: replace dummy return value
		return new OrderResponse(0l, 0l, List.of(
			new OrderItemResponse(0l, 3, ""),
			new OrderItemResponse(0l, 3, "No onions")
		));
	}
}
