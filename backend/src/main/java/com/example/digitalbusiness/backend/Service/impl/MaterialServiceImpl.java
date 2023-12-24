package com.example.digitalbusiness.backend.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalbusiness.backend.Model.Material;
import com.example.digitalbusiness.backend.Repository.MaterialRepository;
import com.example.digitalbusiness.backend.Service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    @Override
    public Long findInventoryById(Long id) {
        Optional<Material> material = materialRepository.findById(id);
        if (material.isPresent()) {
            return material.get().getId();
        } else {
            return null;
        }
    }


}
