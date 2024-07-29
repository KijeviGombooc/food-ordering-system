package com.example.foodorderingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodorderingsystem.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
