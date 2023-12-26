package com.example.digitalbusiness.backend.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalbusiness.backend.Model.Assemble;
import com.example.digitalbusiness.backend.Model.Material;
import com.example.digitalbusiness.backend.Model.Product;
import com.example.digitalbusiness.backend.Repository.MaterialRepository;
import com.example.digitalbusiness.backend.Service.AssembleService;
import com.example.digitalbusiness.backend.Service.MaterialService;
import com.example.digitalbusiness.backend.Service.ProductService;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    ProductService productService;

    @Autowired
    AssembleService assembleService;

    @Override
    public Long findInventoryById(Long id) {
        Optional<Material> material = materialRepository.findById(id);
        if (material.isPresent()) {
            return material.get().getId();
        } else {
            return null;
        }
    }

    @Override
    public List<Material> findAllByProductName(String productName) {
        Product product = productService.findProductByName(productName);
        List<Assemble> assembles = assembleService.findAllByProductId(product.getId());
        List<Material> materials = new ArrayList<>();
        for (Assemble assemble : assembles) {
            materials.add(assemble.getMaterial());
        }
        return materials;
    }

}
