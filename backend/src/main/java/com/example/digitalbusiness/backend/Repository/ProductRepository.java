package com.example.digitalbusiness.backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.digitalbusiness.backend.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCost(Integer cost);
}
