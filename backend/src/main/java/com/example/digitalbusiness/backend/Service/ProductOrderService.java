package com.example.digitalbusiness.backend.Service;

import org.springframework.http.ResponseEntity;

import com.example.digitalbusiness.backend.Model.ProductOrder;

public interface ProductOrderService {

    // Define methods specific to ProductOrder entity
    public ResponseEntity<ProductOrder> saveProductOrder(String productName, String customerName, Integer quantity);
}
