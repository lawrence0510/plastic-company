package com.example.digitalbusiness.backend.Service;

import java.util.List;

import com.example.digitalbusiness.backend.Model.Material;

public interface MaterialService {

    // Define methods specific to Material entity
    public Long findInventoryById(Long id);

    public List<Material> findAllByProductName(String productName);
}
