package com.product.controller;

import com.product.entity.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/get")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping(value = "/add")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.addProducts(products);
    }

    @DeleteMapping(value = "/delete")
    public void deleteProducts(@RequestBody List<Long> productIds) {
         productService.deleteProducts(productIds);
    }

    @PutMapping(value = "/put")
    public List<Product> updateProducts(@RequestBody List<Product> products) {
        return productService.updateProducts(products);
    }
}
