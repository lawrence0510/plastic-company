package com.example.digitalbusiness.backend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    private Long id;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Cost", nullable = false)
    private Integer cost;

    @Column(name = "Duration", nullable = false)
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true, referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "production_line_id", nullable = true, referencedColumnName = "id")
    private ProductionLine productionLine;
}
