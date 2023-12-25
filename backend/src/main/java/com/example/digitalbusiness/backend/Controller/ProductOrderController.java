package com.example.digitalbusiness.backend.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitalbusiness.backend.Model.ProductOrder;
import com.example.digitalbusiness.backend.Service.ProductOrderService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductOrderController {
    @Autowired
    private ProductOrderService productOrderService;

    // Post methods
    @PostMapping("/productOrder")
    public ResponseEntity<ProductOrder> saveProductOrder(@RequestParam("productName") String productName,
            @RequestParam("quantity") Integer Quantity, @RequestParam("CustomerName") String name) {
        ProductOrder result = productOrderService.saveProductOrder(productName, name, Quantity);
        return ResponseEntity.ok().body(result);
    }

    // Get methods
    @GetMapping("/productOrder")
    public ResponseEntity<Collection<ProductOrder>> getAllProductOrder() {
        Collection<ProductOrder> result = productOrderService.getAllProductOrder();
        return ResponseEntity.ok().body(result);
    }

}
