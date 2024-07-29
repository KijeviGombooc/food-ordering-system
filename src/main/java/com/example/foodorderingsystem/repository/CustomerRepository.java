package com.example.foodorderingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodorderingsystem.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
