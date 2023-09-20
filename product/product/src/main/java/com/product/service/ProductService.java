package com.product.service;

import com.product.entity.Product;

import java.util.List;

public interface ProductService {
	
	
    List<Product> getAllProducts();

    List<Product> addProducts(List<Product> products);

    void deleteProducts(List<Long> productIds);

    List<Product> updateProducts(List<Product> products);
}