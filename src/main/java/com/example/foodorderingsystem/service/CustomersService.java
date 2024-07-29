package com.example.foodorderingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorderingsystem.dto.ItemResponse;
import com.example.foodorderingsystem.dto.OrderRequest;
import com.example.foodorderingsystem.dto.RestaurantDetailedResponse;
import com.example.foodorderingsystem.dto.RestaurantResponse;
import com.example.foodorderingsystem.entity.Order;
import com.example.foodorderingsystem.repository.CustomerRepository;
import com.example.foodorderingsystem.repository.ItemRepository;
import com.example.foodorderingsystem.repository.OrderRepository;
import com.example.foodorderingsystem.repository.RestaurantRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomersService {
	@Autowired
	private EntityToDto converter;
	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Transactional
	public List<RestaurantResponse> getRestaurants() {
		return restaurantRepository.findAll().stream().map(converter::restaurantToDto).toList();
	}

	@Transactional
	public RestaurantDetailedResponse getRestaurant(Long id) throws Exception {
		var restaurantResult = restaurantRepository.findById(id);
		if (restaurantResult.isEmpty()) {
			throw new Exception("No restaurant with id: " + id);
		}

		var items = itemRepository.findAllByRestaurant(restaurantResult.get());
		return converter.restaurantAndItemsToDetailedDto(restaurantResult.get(), items);
	}

	@Transactional
	public List<ItemResponse> getRestaurantMenu(Long id) throws Exception {
		var restaurantResult = restaurantRepository.findById(id);
		if (restaurantResult.isEmpty()) {
			throw new Exception("No restaurant with id: " + id);
		}

		var items = itemRepository.findAllByRestaurant(restaurantResult.get());
		return items.stream().map(converter::itemToDto).toList();
	}

	@Transactional
	public void postOrder(OrderRequest orderRequest) throws Exception {
		var customerResult = customerRepository.findById(orderRequest.customerId());
		if (customerResult.isEmpty()) {
			throw new Exception("No customer with id: " + orderRequest.customerId());
		}
		var restaurantResult = restaurantRepository.findById(orderRequest.restaurantId());
		if (restaurantResult.isEmpty()) {
			throw new Exception("No restaurant with id: " + orderRequest.restaurantId());
		}
		List<Long> itemIds = orderRequest.items().stream().map(item -> item.id()).toList();
		var items = itemRepository.findByIdInAndRestaurantId(itemIds, restaurantResult.get().getId());
		if (items.size() != itemIds.size()) {
			throw new Exception("Not all given ids " + itemIds + " are in the restaurant with id: "
					+ restaurantResult.get().getId());
		}

		Order order = converter.orderRequestToEntity(orderRequest, customerResult.get(), restaurantResult.get(), items);
		orderRepository.save(order);
	}
}
