package com.Listing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Listing.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Producer> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Page<Producer> filterProductsByCategory(String category, Pageable pageable) {
        return productRepository.findByCategory(category, pageable);
    }

    public Page<Producer> filterProductsByPriceRange(double minPrice, double maxPrice, Pageable pageable) {
        return productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
    }

    public Page<Producer> searchProducts(String keyword, Pageable pageable) {
        return productRepository.searchProducts(keyword, pageable);
    }
}