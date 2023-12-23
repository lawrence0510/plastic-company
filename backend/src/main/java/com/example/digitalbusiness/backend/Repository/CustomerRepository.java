package com.example.digitalbusiness.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.digitalbusiness.backend.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
