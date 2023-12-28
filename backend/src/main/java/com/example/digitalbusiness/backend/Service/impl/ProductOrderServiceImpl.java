package com.example.digitalbusiness.backend.Service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalbusiness.backend.Model.Customer;
import com.example.digitalbusiness.backend.Model.Produce;
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
    ProductOrderRepository productOrderRepository;

    @Override
    public ProductOrder saveProductOrder(String productName, Integer quantity, String customerName,
            String customerContactName, Integer customerEmployeeCount, String customerPhoneNumber) {
        ProductOrder order = new ProductOrder();

        Product target = productService.findProductByName(productName);
        Customer customer = customerService.FindCustomerByName(customerName);
        if (customer == null) {
            customer = new Customer();
            customer.setName(customerName);
            customer.setContactName(customerContactName);
            customer.setEmployeeCount(customerEmployeeCount);
            customer.setPhoneNumber(customerPhoneNumber);
            customerService.SaveCustomer(customer);
        }
        order.setCustomer(customer);
        order.setProduct(target);
        order.setQuantity(quantity);
        order.setTotalPrice(target.getPrice() * quantity);

        ProductOrder result = null;

        if (productService.checkIfInventoryIsEnough(target.getId(), quantity)) {
            // if inventory is enough, update inventory and setting order status to
            // "completed"
            order.setStatus("completed");
            order.setProgress(1.0);
            productService.updateInventory(target.getId(), quantity);
            // save product order

        } else {
            // if inventory is not enough, setting order status to "processing"
            order.setStatus("processing");
            // arrange produce
            Produce produce = new Produce();
            produce.setProduct(target);
            produce.setQuantity(quantity + 200);
            produce.setDuration(20);
            produce.setCost(20000);

            order.setProduce(produce);
            // calculate order progress
            Integer expectedDurationInDays = produce.getDuration();
            LocalDateTime currentTime = LocalDateTime.now();
            Long daysDifference = ChronoUnit.DAYS.between(order.getDate(), currentTime);
            double orderProgress = Math.min((double) (daysDifference / expectedDurationInDays), 1.0);
            order.setProgress(orderProgress);
        }
        // save product order
        result = productOrderRepository.save(order);
        customerService.updateCustomerValue(customer.getId(), target.getPrice() * quantity, LocalDate.now());

        return result;
    }

    @Override
    public Collection<ProductOrder> getAllProductOrder() {

        Collection<ProductOrder> productOrders = productOrderRepository.findAll();

        for (ProductOrder productOrder : productOrders) {

            if (productOrder.getProgress() != 1.0) {
                Produce produce = productOrder.getProduce();
                Integer expectedDurationInDays = produce.getDuration();
                LocalDateTime currentTime = LocalDateTime.now();
                Long daysDifference = ChronoUnit.DAYS.between(productOrder.getDate(), currentTime);

                double orderProgress = Math.min((double) (daysDifference / expectedDurationInDays), 1.0);
                productOrder.setProgress(orderProgress);
                if (orderProgress == 1.0) {
                    productOrder.setStatus("completed");
                } else {
                    productOrder.setStatus("processing");
                }
            }

        }
        return productOrders;
    }

    @Override
    public List<ProductOrder> findByStatus(String status) {
        List<ProductOrder> result = productOrderRepository.findAllByStatus(status);
        return result;
    }

}
