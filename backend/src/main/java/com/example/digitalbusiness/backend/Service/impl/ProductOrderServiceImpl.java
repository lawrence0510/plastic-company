package com.example.digitalbusiness.backend.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalbusiness.backend.Model.Customer;
import com.example.digitalbusiness.backend.Model.Product;
import com.example.digitalbusiness.backend.Model.ProductOrder;
import com.example.digitalbusiness.backend.Repository.ProductOrderRepository;
import com.example.digitalbusiness.backend.Service.CustomerService;
import com.example.digitalbusiness.backend.Service.ProductOrderService;
import com.example.digitalbusiness.backend.Service.ProductService;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    ProductService productService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ProductOrderRepository productorderRepository;

    @Override
    public ProductOrder saveProductOrder(String productName, String customerName, Integer quantity) {
        ProductOrder order = new ProductOrder();

        Product target = productService.FindProductByName(productName);
        Customer customer = customerService.FindCustomerByName(customerName);

        order.setCustomer(customer);
        order.setProduct(target);
        order.setQuantity(quantity);

        ProductOrder result = null;

        if (productService.checkIfInventoryIsEnough(target.getId(), quantity)) {
            // if inventory is enough, update inventory and setting order status to
            // "completed"
            order.setStatus("completed");
            productService.updateInventory(target.getId(), quantity);
            // save product order
            result = productorderRepository.save(order);
        } else {
            // if inventory is not enough, setting order status to "processing"
            order.setStatus("processing");
            // arrage production line
            // save product order
            result = productorderRepository.save(order);
        }
        return result;
    }

    // Implement methods specific to ProductOrder entity

}
