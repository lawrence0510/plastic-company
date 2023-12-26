package com.example.digitalbusiness.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitalbusiness.backend.Model.Material;
import com.example.digitalbusiness.backend.Service.MaterialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/materials/search/findByProductName")
    public ResponseEntity<List<Material>> getMethodName(@RequestParam String productName) {
        List<Material> result = materialService.findAllByProductName(productName);
        return ResponseEntity.ok().body(result);
    }

}
