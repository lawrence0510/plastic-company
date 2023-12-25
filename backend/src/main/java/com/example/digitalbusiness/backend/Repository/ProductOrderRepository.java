package com.example.digitalbusiness.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.digitalbusiness.backend.Model.ProductOrder;

@CrossOrigin
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
}
