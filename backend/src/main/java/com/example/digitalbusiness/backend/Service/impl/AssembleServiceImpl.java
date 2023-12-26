package com.example.digitalbusiness.backend.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalbusiness.backend.Model.Assemble;
import com.example.digitalbusiness.backend.Repository.AssembleRepository;
import com.example.digitalbusiness.backend.Service.AssembleService;

@Service
public class AssembleServiceImpl implements AssembleService {

    @Autowired
    AssembleRepository assembleRepository;

    @Override
    public List<Assemble> findAllByProductId(Long productId) {
        List<Assemble> result = assembleRepository.findAllByProductId(productId);
        if (result != null) {
            return result;
        } else {
            return null;
        }
    }

    // Implement methods specific to Assemble entity

}
