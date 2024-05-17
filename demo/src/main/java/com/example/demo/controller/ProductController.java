package com.example.demo.controller;

import com.example.demo.dto.ProductRequest;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody @Valid ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable("id") int id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @PutMapping("{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody @Valid ProductRequest productRequest) throws ProductNotFoundException {
        return productService.updateProduct(id, productRequest);
    }

    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable("id") int id) throws ProductNotFoundException {
        return productService.deleteProduct(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
