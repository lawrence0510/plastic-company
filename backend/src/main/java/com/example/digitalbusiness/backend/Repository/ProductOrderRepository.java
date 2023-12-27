package com.example.digitalbusiness.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.digitalbusiness.backend.Model.ProductOrder;
import java.util.List;

@CrossOrigin
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
    List<ProductOrder> findAllByStatus(String status);

    List<ProductOrder> findAllByCustomerId(Long customerId);
}
