package com.example.digitalbusiness.backend.Repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.digitalbusiness.backend.Model.Assemble;
import com.example.digitalbusiness.backend.Model.Product;
import java.util.List;

@CrossOrigin
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCost(Integer cost);

    Set<Product> findByNameContaining(String name);

    Optional<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.inventory <= 200")
    List<Product> findProductsWithInventoryLessThan200();

}
