package com.example.digitalbusiness.backend.Service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.digitalbusiness.backend.Model.Product;
import com.example.digitalbusiness.backend.Repository.ProductRepository;
import com.example.digitalbusiness.backend.Service.ProductService;

public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public Collection<Product> getProducts() {
        Collection<Product> result = productRepository.findAll();
        return result;
    };

}
