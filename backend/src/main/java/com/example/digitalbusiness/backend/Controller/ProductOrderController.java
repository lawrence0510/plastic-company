package com.example.digitalbusiness.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitalbusiness.backend.Model.ProductOrder;
import com.example.digitalbusiness.backend.Service.ProductOrderService;

import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductOrderController {
    @Autowired
    private ProductOrderService productorderService;

    // Post methods
    @PostMapping("/productOrder")
    public ResponseEntity<ProductOrder> saveProductOrder(@RequestParam("productName") String productName,
            @RequestParam("quentity") Integer Quantity, @RequestParam("CustomerName") String name) {
        ProductOrder result = productorderService.saveProductOrder(productName, name, Quantity);
        return ResponseEntity.ok().body(result);
    }

}
