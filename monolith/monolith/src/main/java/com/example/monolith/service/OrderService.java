package com.example.monolith.service;

import com.example.monolith.entity.Order;
import com.example.monolith.entity.Product;
import com.example.monolith.repository.OrderRepository;
import com.example.monolith.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ProductRepository productRepo;

    public Order placeOrder(Order order) {
        Product product = productRepo.findById(order.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        order.setProduct(product);
        return orderRepo.save(order);
    }


    public Optional<Order> getOrderById(Long id) {
        return orderRepo.findById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public void deleteOrder(Long id) {
        if (!orderRepo.existsById(id)) {
            throw new RuntimeException("Order not found with id: " + id);
        }
        orderRepo.deleteById(id);
    }
}
