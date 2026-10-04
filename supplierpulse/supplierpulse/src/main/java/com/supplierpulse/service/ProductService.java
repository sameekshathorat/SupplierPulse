package com.supplierpulse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supplierpulse.model.Product;
import com.supplierpulse.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
