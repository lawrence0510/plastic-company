package com.example.digitalbusiness.backend.Model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
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
    private Long id;

    @Column(name = "Recency", nullable = false)
    private double recency;

    @Column(name = "Frequency", nullable = false)
    private double frequency;

    @Column(name = "MonetaryValue", nullable = false)
    private double monetaryValue;

    @Column(name = "CreateAt", nullable = true)
    private LocalDate createAt;

    @Column(name = "customerLTV", nullable = true)
    private double customerLTV;

    private double averagePurchaseValue;
    private double averagePurchaseFrequency;
    private double customerValue;
    private double averageCustomerLifespan;

    @OneToOne
    @MapsId
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonBackReference(value = "customer-customerValue")
    private Customer customer;

    @PrePersist
    public void prePersist() {
        this.createAt = LocalDate.now();
    }
}
