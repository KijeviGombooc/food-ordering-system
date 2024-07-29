package com.example.foodorderingsystem.dto;

import com.example.foodorderingsystem.entity.OrderStatus;

public record OrderStatusRequest(
		OrderStatus status) {
}
