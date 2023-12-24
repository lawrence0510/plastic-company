package com.example.digitalbusiness.backend.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalbusiness.backend.Model.Customer;
import com.example.digitalbusiness.backend.Repository.CustomerRepository;
import com.example.digitalbusiness.backend.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer FindCustomerByName(String customerName) {
        Customer result = customerRepository.findByName(customerName).get();
        return result;
    }

    // Implement methods specific to Customer entity

}
