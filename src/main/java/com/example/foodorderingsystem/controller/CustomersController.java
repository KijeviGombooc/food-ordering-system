package com.example.foodorderingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodorderingsystem.dto.ItemResponse;
import com.example.foodorderingsystem.dto.OrderRequest;
import com.example.foodorderingsystem.dto.RestaurantDetailedResponse;
import com.example.foodorderingsystem.dto.RestaurantResponse;
import com.example.foodorderingsystem.service.CustomersService;

@RestController
public class CustomersController {

	@Autowired
	private CustomersService customersService;

	@GetMapping("/restaurants")
	public List<RestaurantResponse> getRestaurants() {
		return customersService.getRestaurants();
	}

	@GetMapping("/restaurants/{id}")
	public RestaurantDetailedResponse getRestaurant(@PathVariable Long id) {
		return customersService.getRestaurant(id);
	}

	@GetMapping("/restaurants/{id}/menu")
	public List<ItemResponse> getRestaurantMenu(@PathVariable Long id) {
		return customersService.getRestaurantMenu(id);
	}

	@PostMapping("/orders")
	public void postOrder(@RequestBody OrderRequest orderRequest) {
		customersService.postOrder(orderRequest);
	}
}
