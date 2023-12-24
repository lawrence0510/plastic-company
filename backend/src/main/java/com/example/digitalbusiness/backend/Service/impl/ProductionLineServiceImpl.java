package com.example.digitalbusiness.backend.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.digitalbusiness.backend.Model.ProductionLine;
import com.example.digitalbusiness.backend.Repository.ProductionLineRepository;
import com.example.digitalbusiness.backend.Service.ProductionLineService;

public class ProductionLineServiceImpl implements ProductionLineService {

    @Autowired
    ProductionLineRepository productionlineRepository;

    // Implement methods specific to ProductionLine entity

}
