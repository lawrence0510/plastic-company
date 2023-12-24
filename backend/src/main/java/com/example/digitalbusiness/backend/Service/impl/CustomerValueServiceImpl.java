package com.example.digitalbusiness.backend.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.digitalbusiness.backend.Model.CustomerValue;
import com.example.digitalbusiness.backend.Repository.CustomerValueRepository;
import com.example.digitalbusiness.backend.Service.CustomerValueService;

public class CustomerValueServiceImpl implements CustomerValueService {

    @Autowired
    CustomerValueRepository customervalueRepository;

    // Implement methods specific to CustomerValue entity

}
