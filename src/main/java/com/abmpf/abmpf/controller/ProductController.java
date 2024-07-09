package com.abmpf.abmpf.controller;

import com.abmpf.abmpf.entities.Product;
import com.abmpf.abmpf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{pid}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer pid) {
        return ResponseEntity.ok(productService.getProductById(pid));
    }

    @PutMapping("/{pid}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer pid, @RequestBody Product productDetails) {
        return ResponseEntity.ok(productService.updateProduct(pid, productDetails));
    }
}
