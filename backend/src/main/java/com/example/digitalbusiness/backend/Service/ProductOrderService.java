package com.example.digitalbusiness.backend.Service;

import com.example.digitalbusiness.backend.Model.ProductOrder;

public interface ProductOrderService {

    // Define methods specific to ProductOrder entity
    public ProductOrder saveProductOrder(String productName, String customerName, Integer quantity);
}
