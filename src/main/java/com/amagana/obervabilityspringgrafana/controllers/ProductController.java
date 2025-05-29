package com.amagana.obervabilityspringgrafana.controllers;

import com.amagana.obervabilityspringgrafana.entities.Products;
import com.amagana.obervabilityspringgrafana.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Products getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
