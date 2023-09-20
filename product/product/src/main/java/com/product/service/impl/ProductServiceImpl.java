package com.product.service.impl;

import com.product.entity.Product;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findByIsDeletedFalse();
    }

    @Override
    public List<Product> addProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public void deleteProducts(List<Long> productIds) {
         productRepository.deleteProducts(productIds);
    }

    @Override
    public List<Product> updateProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

}