package com.example.digitalbusiness.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.digitalbusiness.backend.Model.Material;

public interface MaterialRepository extends JpaRepository<Material, Long>{
    
}
