package com.example.digitalbusiness.backend.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalbusiness.backend.Repository.ProductionLineRepository;
import com.example.digitalbusiness.backend.Service.ProductionLineService;

@Service
public class ProductionLineServiceImpl implements ProductionLineService {

    @Autowired
    ProductionLineRepository productionLineRepository;

    // Implement methods specific to ProductionLine entity

}
