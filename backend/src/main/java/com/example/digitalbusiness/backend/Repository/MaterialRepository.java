package com.example.digitalbusiness.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.digitalbusiness.backend.Model.Material;

@CrossOrigin(origins = "http://localhost:80")
public interface MaterialRepository extends JpaRepository<Material, Long> {

    @Query("SELECT m FROM Material m WHERE m.inventory < 100")
    List<Material> findMaterialsWithInventoryLessThan100();
}
