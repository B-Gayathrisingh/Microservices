package com.example.monolith.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.monolith.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}