package com.example.demo.service.impl;

import com.example.demo.dto.ProductRequest;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product createProduct(ProductRequest productRequest) {
        Product product = Product.build(0,productRequest.getName(),productRequest.getDescription(),productRequest.getPrice(),productRequest.getQuantity());
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(int id) throws ProductNotFoundException {
        Product product=productRepository.findById(id).orElse(null);
        if(product!=null){
            return product;
        }else {
            throw new ProductNotFoundException("Product not found");
        }
    }

    @Override
    public Product updateProduct(int id,ProductRequest productRequest) throws ProductNotFoundException {
        Product product=productRepository.findById(id).orElse(null);
        if (product!=null) {
            product.setName(productRequest.getName());
            product.setDescription(productRequest.getDescription());
            product.setPrice(productRequest.getPrice());
            product.setQuantity(productRequest.getQuantity());
            return productRepository.save(product);
        }
        else {
            throw new ProductNotFoundException("Product not found");
        }
    }

    @Override
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product deleted successfully";
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
