package com.example.monolith.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="order")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String customerName;
	private Integer quantityOrdered;
	
	@ManyToOne
	@JoinColumn(name ="product_id")
	private Product product;

	public Order() {}

	public Order(Long id, String customerName, Integer quantityIrdered, Product product) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.quantityOrdered = quantityOrdered;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityIrdered) {
		this.quantityOrdered = quantityIrdered;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	

}