package com.example.digitalbusiness.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Produce")
public class Produce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ProductionLineID", nullable = false)
    private Integer productionLineId;

    @Column(name = "ProductID", nullable = false)
    private Integer productId;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Cost", nullable = false)
    private Integer cost;

    @Column(name = "Date", nullable = false)
    private Date date;
}
