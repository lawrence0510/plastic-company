package com.example.digitalbusiness.backend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Assemble")
public class Assemble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ProductID", nullable = false)
    private Long productId;

    @Column(name = "MaterialID", nullable = false)
    private Long materialId;

    @Column(name = "MaterialQuantity", nullable = false)
    private Integer materialQuantity;
}