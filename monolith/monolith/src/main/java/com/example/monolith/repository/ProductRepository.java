package com.example.monolith.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.monolith.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}