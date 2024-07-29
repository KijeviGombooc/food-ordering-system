package com.example.foodorderingsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.foodorderingsystem.dto.ItemResponse;
import com.example.foodorderingsystem.dto.OrderItemResponse;
import com.example.foodorderingsystem.dto.OrderRequest;
import com.example.foodorderingsystem.dto.OrderResponse;
import com.example.foodorderingsystem.dto.OrderStatusDto;
import com.example.foodorderingsystem.dto.RestaurantDetailedResponse;
import com.example.foodorderingsystem.dto.RestaurantResponse;
import com.example.foodorderingsystem.entity.Customer;
import com.example.foodorderingsystem.entity.Item;
import com.example.foodorderingsystem.entity.Order;
import com.example.foodorderingsystem.entity.OrderItem;
import com.example.foodorderingsystem.entity.OrderStatus;
import com.example.foodorderingsystem.entity.Restaurant;

@Component
public class EntityToDto {

	public RestaurantResponse restaurantToDto(Restaurant restaurant) {
		return new RestaurantResponse(restaurant.getId(), restaurant.getName());
	}

	public RestaurantDetailedResponse restaurantAndItemsToDetailedDto(Restaurant restaurant, List<Item> items) {
		var itemResponses = items.stream().map(this::itemToDto).toList();
		return new RestaurantDetailedResponse(restaurant.getId(), restaurant.getName(), itemResponses);
	}

	public ItemResponse itemToDto(Item item) {
		return new ItemResponse(item.getId(), item.getName(), item.getDescription(), item.getPrice());
	}

	public Order orderRequestToEntity(OrderRequest orderRequest, Customer customer, Restaurant restaurant, List<Item> items) {
		var itemsMap = items.stream().collect(Collectors.toMap(Item::getId, item -> item));
		List<OrderItem> orderItems = orderRequest.items().stream().map((orderItemRequest -> {
			OrderItem orderItem = new OrderItem();
			orderItem.setItem(itemsMap.get(orderItemRequest.id()));
			orderItem.setQuantity(orderItemRequest.quantity());
			orderItem.setSpecialInstructions(orderItemRequest.specialInstructions());
			return orderItem;
		})).toList();
		Order order = new Order();
		order.setCustomer(customer);
		order.setRestaurant(restaurant);
		order.setStatus(OrderStatus.RECEIVED);
		order.setItems(orderItems);
		return order;
	}

	public OrderResponse orderToDto(Order order) {
		return new OrderResponse(
			order.getId(),
			order.getCustomer().getId(),
			order.getRestaurant().getId(),
			OrderStatusDto.valueOf(order.getStatus().name()),
			order.getItems().stream().map(this::orderItemToDto).toList()
		);
	}

	public OrderItemResponse orderItemToDto(OrderItem orderItem) {
		return new OrderItemResponse(orderItem.getId(), orderItem.getQuantity(), orderItem.getSpecialInstructions());
	}
}
