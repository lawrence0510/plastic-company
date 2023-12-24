package com.example.digitalbusiness.backend.Service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalbusiness.backend.Model.Product;
import com.example.digitalbusiness.backend.Repository.ProductRepository;
import com.example.digitalbusiness.backend.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public Collection<Product> getProducts() {
        Collection<Product> result = productRepository.findAll();
        return result;
    }

    @Override
    public boolean checkIfInventoryIsEnough(Long product_id, Integer quantity) {
        Product target = productRepository.findById(product_id).orElseThrow();
        if (target.getInventory() >= quantity) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Product updateInventory(Long product_id, Integer quantity) {
        Product target = productRepository.findById(product_id).orElseThrow();
        target.setInventory(target.getInventory() - quantity);
        Product result = productRepository.save(target);
        return result;
    }

    @Override
    public Product FindProductByName(String productName) {
        Product result = productRepository.findByName(productName).get();
        return result;
    };

}
