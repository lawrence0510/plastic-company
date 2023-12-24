package com.example.digitalbusiness.backend.Repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.digitalbusiness.backend.Model.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCost(Integer cost);

    Set<Product> findByNameContaining(String name);

    @Query("SELECT p FROM Product p WHERE p.inventory < 100")
    List<Product> findProductsWithInventoryLessThan100();
}
