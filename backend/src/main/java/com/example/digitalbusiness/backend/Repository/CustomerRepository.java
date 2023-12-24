package com.example.digitalbusiness.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.digitalbusiness.backend.Model.Customer;

@CrossOrigin
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
