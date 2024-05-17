package com.example.demo.service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {

    public Product createProduct(ProductRequest productRequest);
    public Product getProductById(int id) throws ProductNotFoundException;
    public Product updateProduct(int id,ProductRequest productRequest)throws ProductNotFoundException;
    public String deleteProduct(int id);
    public List<Product> getAllProducts();
}
