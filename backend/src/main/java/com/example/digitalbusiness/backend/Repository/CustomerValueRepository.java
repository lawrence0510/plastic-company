package com.example.digitalbusiness.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.digitalbusiness.backend.Model.CustomerValue;

public interface CustomerValueRepository extends JpaRepository<CustomerValue, Long> {

}
