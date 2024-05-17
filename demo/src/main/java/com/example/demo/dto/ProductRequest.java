package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class ProductRequest {
    @NotNull(message = "product name should not be null")
    private String name;
    private String description;
    @NotNull(message = "product price should not be null")
    private Double price;
    @NotNull(message = "product quantity should not be null")
    private int quantity;
}
