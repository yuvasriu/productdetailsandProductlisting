package com.product.controller;

import com.product.entity.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    
    public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
    
    @PostMapping(value="/post")
    public ResponseEntity<Product> postproduct(@RequestBody Product product){
    	product = productService.saveProduct(product);
    	return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value="/delete")
    public ResponseEntity<Product> removeProduct(@RequestParam long id){
    	productService.deleteProduct(id);
    	return new ResponseEntity<Product>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/update") 
    public ResponseEntity<Product> updateProduct(@RequestBody Product product)    {
    	productService.saveOrUpdate(product);   
    	 return  new ResponseEntity<Product>(product,HttpStatus.ACCEPTED); 
    	 }
    
    
    
    





//    @GetMapping(value = "/get")
//   public List<Product> getProducts() {
//        return productService.getAllProducts();
//   }



//    @DeleteMapping(value = "/delete")
//    public void deleteProducts(@RequestBody List<Long> productIds) {
//         productService.deleteProducts(productIds);
//    }
//
//    @PutMapping(value = "/put")
//    public List<Product> updateProducts(@RequestBody List<Product> products) {
//        return productService.updateProducts(products);
//    }
}
