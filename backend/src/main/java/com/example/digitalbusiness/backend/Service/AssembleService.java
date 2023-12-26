package com.example.digitalbusiness.backend.Service;

import java.util.List;

import com.example.digitalbusiness.backend.Model.Assemble;

public interface AssembleService {

    // Define methods specific to Assemble entity
    public List<Assemble> findAllByProductId(Long productId);
}
