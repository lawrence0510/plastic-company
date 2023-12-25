package com.example.digitalbusiness.backend.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalbusiness.backend.Repository.AssembleRepository;
import com.example.digitalbusiness.backend.Service.AssembleService;

@Service
public class AssembleServiceImpl implements AssembleService {

    @Autowired
    AssembleRepository assembleRepository;

    // Implement methods specific to Assemble entity

}
