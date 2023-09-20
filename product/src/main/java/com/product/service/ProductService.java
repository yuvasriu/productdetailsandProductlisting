package com.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService{
	
	@Autowired
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	
	public Product saveProduct(Product product) {
		product=productRepository.save(product);
		return product;
	}
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	public void update(Product product, Long id)
	{
		productRepository.save(product);
		} 
	
	
	public void saveOrUpdate(Product product) {
		productRepository.save(product);
	}
	
	
}