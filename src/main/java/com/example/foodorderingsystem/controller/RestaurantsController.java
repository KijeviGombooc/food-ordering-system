package com.example.foodorderingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodorderingsystem.dto.OrderResponse;
import com.example.foodorderingsystem.dto.OrderStatusRequest;
import com.example.foodorderingsystem.service.RestaurantsService;

@RestController
public class RestaurantsController {

	@Autowired
	private RestaurantsService restaurantsService;

	@GetMapping("/orders")
	public List<OrderResponse> getOrders() {
		return restaurantsService.getOrders();
	}

	@PatchMapping("/orders/{id}")
	public void patchOrder(@PathVariable Long id, @RequestBody OrderStatusRequest orderStatusRequest) throws Exception {
		restaurantsService.patchOrder(id, orderStatusRequest);
	}

	@GetMapping("/orders/{id}")
	public OrderResponse getOrder(@PathVariable Long id) throws Exception {
		return restaurantsService.getOrder(id);
	}
}
