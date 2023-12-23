package com.example.digitalbusiness.backend.Model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false, length = 30)
    private String name;

    @Column(name = "Price", nullable = false)
    private Integer price;

    @Column(name = "Cost", nullable = false)
    private Integer cost;

    @Column(name = "NetIncome", nullable = false)
    private Integer netIncome;

    @Column(name = "Inventory", nullable = false)
    private Integer inventory;

    @OneToMany(mappedBy = "product")
    private Set<Assemble> assembles;

    @OneToMany(mappedBy = "product")
    private Set<Produce> produces;

    @OneToMany(mappedBy = "product")
    private Set<ProductOrder> productOrders;
}