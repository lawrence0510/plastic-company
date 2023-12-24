package com.example.digitalbusiness.backend.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.digitalbusiness.backend.Model.Customer;
import com.example.digitalbusiness.backend.Repository.CustomerRepository;
import com.example.digitalbusiness.backend.Service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    // Implement methods specific to Customer entity

}
