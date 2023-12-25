package com.example.digitalbusiness.backend.Service.impl;

import java.util.Optional;

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
        Optional<Customer> result = customerRepository.findByName(customerName);
        if (result.isPresent())
            return result.get();
        else
            return null;
    }

    @Override
    public Customer SaveCustomer(Customer customer) {
        Customer result = customerRepository.save(customer);
        return result;
    }

}
