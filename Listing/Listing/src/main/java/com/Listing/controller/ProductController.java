package com.Listing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.Listing.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Producer> getAllProducts(Pageable pageable) {
        return productService.getAllProducts(pageable);
    }

    @GetMapping("/filter/category")
    public Page<Producer> filterProductsByCategory(
            @RequestParam(name = "category") String category,
            Pageable pageable) {
        return productService.filterProductsByCategory(category, pageable);
    }

    @GetMapping("/filter/price")
    public Page<Producer> filterProductsByPriceRange(
            @RequestParam(name = "minPrice") double minPrice,
            @RequestParam(name = "maxPrice") double maxPrice,
            Pageable pageable) {
        return productService.filterProductsByPriceRange(minPrice, maxPrice, pageable);
    }

    @GetMapping("/search")
    public Page<Producer> searchProducts(
            @RequestParam(name = "keyword") String keyword,
            Pageable pageable) {
        return productService.searchProducts(keyword, pageable);
    }
}