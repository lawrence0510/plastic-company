package com.example.digitalbusiness.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.digitalbusiness.backend.Model.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    @Query("SELECT m FROM Material m WHERE m.inventory < 100")
    List<Material> findMaterialsWithInventoryLessThan100();
}
