package com.example.foodorderingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodorderingsystem.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
