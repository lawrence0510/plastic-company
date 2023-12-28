package com.example.digitalbusiness.backend.Service;

import java.time.LocalDate;

import com.example.digitalbusiness.backend.Model.Customer;

public interface CustomerService {

    // Define methods specific to Customer entity
    public Customer FindCustomerByName(String customerName);

    public Customer SaveCustomer(Customer customer);

    public void updateCustomerValue(Long customerId, Integer totalPrice, LocalDate orderDate);
}
