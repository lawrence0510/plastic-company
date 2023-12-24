package com.example.digitalbusiness.backend.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.digitalbusiness.backend.Model.ProductOrder;
import com.example.digitalbusiness.backend.Repository.ProductOrderRepository;
import com.example.digitalbusiness.backend.Service.ProductOrderService;

public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    ProductOrderRepository productorderRepository;

    // Implement methods specific to ProductOrder entity

}
