package com.abmpf.abmpf.service;

import com.abmpf.abmpf.entities.Product;
import com.abmpf.abmpf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(Integer id, Product productDetails) {
        Product product = getProductById(id);
        product.setDescription(productDetails.getDescription());
        product.setCode(productDetails.getCode());
        product.setStock(productDetails.getStock());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }
}
