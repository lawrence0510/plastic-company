package com.example.digitalbusiness.backend.Service;

import java.util.Collection;

import com.example.digitalbusiness.backend.Model.ProductOrder;

public interface ProductOrderService {

    // Define methods specific to ProductOrder entity
    public ProductOrder saveProductOrder(String productName, Integer quantity, String customerName,
            String customerContactName, Integer customerEmployeeCount);

    public Collection<ProductOrder> getAllProductOrder();
}
