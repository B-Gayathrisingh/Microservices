package com.example.monolith.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.monolith.entity.Product;
import com.example.monolith.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productrepo;
	
	public Product addProduct(Product product) {
		return productrepo.save(product);
	}
	
	public List<Product>getAllProducts(){
		return productrepo.findAll();
	}
	public Optional<Product>getProductById(Long id){
		return productrepo.findById(id);
	}
	
	public Product updateProduct(Long id,Product product) {
		return productrepo.findById(id).map(p->{
			p.setName(product.getName());
			p.setPrice(product.getPrice());
			p.setQuantity(product.getQuantity());
			return productrepo.save(p);
		}).orElseThrow(()->new RuntimeException("product not found"));
	}
	public void deleteProduct(Long id) {
		productrepo.deleteById(id);
	}

}