package com.example.digitalbusiness.backend.Service;

import com.example.digitalbusiness.backend.Model.Customer;

public interface CustomerService {

    // Define methods specific to Customer entity
    public Customer FindCustomerByName(String customerName);

    public Customer SaveCustomer(Customer customer);
}
