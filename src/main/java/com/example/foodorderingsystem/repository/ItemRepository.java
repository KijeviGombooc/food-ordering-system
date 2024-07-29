package com.example.foodorderingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodorderingsystem.entity.Item;
import com.example.foodorderingsystem.entity.Restaurant;

public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findAllByRestaurant(Restaurant restaurant);

	List<Item> findByIdInAndRestaurantId(List<Long> ids, Long restaurantId);
}
