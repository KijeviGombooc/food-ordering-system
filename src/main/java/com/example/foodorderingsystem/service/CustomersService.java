package com.example.foodorderingsystem.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.foodorderingsystem.dto.ItemResponse;
import com.example.foodorderingsystem.dto.OrderRequest;
import com.example.foodorderingsystem.dto.RestaurantDetailedResponse;
import com.example.foodorderingsystem.dto.RestaurantResponse;

@Service
public class CustomersService {

	public List<RestaurantResponse> getRestaurants() {
		// TODO: replace dummy return value
		return List.of(
			new RestaurantResponse(0l, "Restaurant 1"),
			new RestaurantResponse(0l, "Restaurant 2")
		);
	}

	public RestaurantDetailedResponse getRestaurant(Long id) {
		// TODO: replace dummy return value
		return new RestaurantDetailedResponse(0l, "Restaurant 1", List.of(
			new ItemResponse(0l, "Item 1", "Description 1", new BigDecimal(123.123)),
			new ItemResponse(0l, "Item 2", "Description 2", new BigDecimal(123.123))
		));
	}

	public List<ItemResponse> getRestaurantMenu(Long id) {
		// TODO: replace dummy return value
		return List.of(
			new ItemResponse(0l, "Item 1", "Description 1", new BigDecimal(123.123)),
			new ItemResponse(0l, "Item 2", "Description 2", new BigDecimal(123.123))
		);
	}

	public void postOrder(OrderRequest orderRequest) {
		// TODO: replace dummy return value
	}
}
