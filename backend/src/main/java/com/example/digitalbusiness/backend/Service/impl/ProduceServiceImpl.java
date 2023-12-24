package com.example.digitalbusiness.backend.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalbusiness.backend.Model.Produce;
import com.example.digitalbusiness.backend.Repository.ProduceRepository;
import com.example.digitalbusiness.backend.Service.ProduceService;

@Service
public class ProduceServiceImpl implements ProduceService {

    @Autowired
    ProduceRepository produceRepository;

    // Implement methods specific to Produce entity

}
