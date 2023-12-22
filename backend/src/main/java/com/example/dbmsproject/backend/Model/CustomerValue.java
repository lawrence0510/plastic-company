package com.example.digitalbusiness.backend.model;

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
@Table(name = "CustomerValue")
public class CustomerValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Recency", nullable = false)
    private Integer recency;

    @Column(name = "Frequency", nullable = false)
    private Integer frequency;

    @Column(name = "MonetaryValue", nullable = false)
    private Integer monetaryValue;
}
