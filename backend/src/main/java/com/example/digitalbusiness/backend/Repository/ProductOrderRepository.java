package com.example.digitalbusiness.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.digitalbusiness.backend.Model.ProductOrder;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

}
