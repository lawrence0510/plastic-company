package com.example.digitalbusiness.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Form")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Time", nullable = false)
    private LocalDate time; // Assuming you are using LocalDate for date without time information

    @Column(name = "CustomerID", nullable = false)
    private Integer customerId;

    @Column(name = "ProductID", nullable = false)
    private Integer productId;
}
