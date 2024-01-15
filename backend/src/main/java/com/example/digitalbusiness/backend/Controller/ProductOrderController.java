package com.example.digitalbusiness.backend.Controller;

import java.util.Collection;
import java.util.List;

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

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductOrderController {
    @Autowired
    private ProductOrderService productOrderService;

    // Post methods
    @PostMapping("/productOrder")
    public ResponseEntity<ProductOrder> saveProductOrder(@RequestParam("productName") String productName,
            @RequestParam("quantity") Integer Quantity, @RequestParam("CustomerName") String customerName,
            @RequestParam(value = "CustomerContactName", required = false) String customerContactName,
            @RequestParam(value = "CustomerEmployeeCount", required = false) Integer customerEmployeeCount,
            @RequestParam(value = "CustomerPhoneNumber", required = false) String customerPhoneNumber) {
        ProductOrder result = productOrderService.saveProductOrder(productName, Quantity, customerName,
                customerContactName, customerEmployeeCount, customerPhoneNumber);
        return ResponseEntity.ok().body(result);
    }

    // Get methods
    @GetMapping("/productOrder")
    public ResponseEntity<Collection<ProductOrder>> getAllProductOrder() {
        Collection<ProductOrder> result = productOrderService.getAllProductOrder();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/productOrder/FindByStatus")
    public ResponseEntity<Collection<ProductOrder>> getMethodName(@RequestParam String status) {
        List<ProductOrder> result = productOrderService.findByStatus(status);
        return ResponseEntity.ok().body(result);
    }

}
