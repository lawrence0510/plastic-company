package com.example.digitalbusiness.backend.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.digitalbusiness.backend.Model.Material;
import com.example.digitalbusiness.backend.Repository.MaterialRepository;
import com.example.digitalbusiness.backend.Service.MaterialService;

public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    // Implement methods specific to Material entity

}
