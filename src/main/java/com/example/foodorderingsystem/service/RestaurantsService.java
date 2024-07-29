package com.example.foodorderingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorderingsystem.dto.OrderResponse;
import com.example.foodorderingsystem.dto.OrderStatusRequest;
import com.example.foodorderingsystem.entity.OrderStatus;
import com.example.foodorderingsystem.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class RestaurantsService {
	@Autowired
	private EntityToDto converter;
	@Autowired
	private OrderRepository orderRepository;

	@Transactional
	public List<OrderResponse> getOrders() {
		return orderRepository.findAll().stream().map(converter::orderToDto).toList();
	}

	@Transactional
	public void patchOrder(Long id, OrderStatusRequest orderStatusRequest) throws Exception {
		var orderResult = orderRepository.findById(id);
		if (orderResult.isEmpty()) {
			throw new Exception("No order with id: " + id);
		}

		orderResult.get().setStatus(OrderStatus.valueOf(orderStatusRequest.status().name()));
		orderRepository.save(orderResult.get());
	}

	@Transactional
	public OrderResponse getOrder(Long id) throws Exception {
		var orderResult = orderRepository.findById(id);
		if (orderResult.isEmpty()) {
			throw new Exception("No order with id: " + id);
		}

		return converter.orderToDto(orderResult.get());
	}
}
