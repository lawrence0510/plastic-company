package com.example.digitalbusiness.backend.Service;

import com.example.digitalbusiness.backend.Model.Product;

public interface ProductService {
    public boolean checkIfInventoryIsEnough(Long product_id, Integer quantity);

    public Product updateInventory(Long product_id, Integer quantity);

    public Product findProductByName(String productName);
}
