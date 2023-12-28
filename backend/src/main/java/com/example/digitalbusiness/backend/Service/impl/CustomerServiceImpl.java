package com.example.digitalbusiness.backend.Service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalbusiness.backend.Model.Customer;
import com.example.digitalbusiness.backend.Model.CustomerValue;
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

    @Override
    public void updateCustomerValue(Long customerId, Integer totalPrice, LocalDate orderDate) {
        Customer customer = customerRepository.findById(customerId).get();
        CustomerValue customerValue = customer.getCustomerValue();
        if (totalPrice != 0) {
            if (customerValue == null) {
                CustomerValue newCustomerValue = new CustomerValue();
                newCustomerValue.setFrequency(1);
                newCustomerValue.setMonetaryValue(totalPrice);
                newCustomerValue.setRecency(ChronoUnit.DAYS.between(orderDate, LocalDate.now()));
                newCustomerValue.setAveragePurchaseValue(totalPrice);
                newCustomerValue.setAveragePurchaseFrequency(1);
                newCustomerValue.setCustomerValue(totalPrice);
                newCustomerValue.setAverageCustomerLifespan(10);
            } else {
                customerValue.setFrequency(customerValue.getFrequency() + 1);
                customerValue.setMonetaryValue(customerValue.getMonetaryValue() + totalPrice);
                customerValue.setRecency(ChronoUnit.DAYS.between(orderDate, LocalDate.now()));
                customerValue.setAveragePurchaseValue(customerValue.getMonetaryValue() / customerValue.getFrequency());
                customerValue.setAveragePurchaseFrequency(customerValue.getFrequency()
                        / ChronoUnit.DAYS.between(customerValue.getCreateAt(), LocalDate.now()));
                customerValue.setCustomerValue(
                        customerValue.getAveragePurchaseValue() * customerValue.getAveragePurchaseFrequency());
                customerValue
                        .setCustomerLTV(customerValue.getCustomerValue() * customerValue.getAverageCustomerLifespan());
            }
        } else {
            customerValue.setRecency(ChronoUnit.DAYS.between(orderDate, LocalDate.now()));
            customerValue.setAveragePurchaseValue(customerValue.getMonetaryValue() / customerValue.getFrequency());
            customerValue.setAveragePurchaseFrequency(customerValue.getFrequency()
                    / ChronoUnit.DAYS.between(customerValue.getCreateAt(), LocalDate.now()));
            customerValue.setCustomerValue(
                    customerValue.getAveragePurchaseValue() * customerValue.getAveragePurchaseFrequency());
            customerValue
                    .setCustomerLTV(customerValue.getCustomerValue() * customerValue.getAverageCustomerLifespan());
        }
        customer.setCustomerValue(customerValue);
        customerRepository.save(customer);
    }

}
