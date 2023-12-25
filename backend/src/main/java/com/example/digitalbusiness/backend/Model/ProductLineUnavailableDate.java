package com.example.digitalbusiness.backend.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ProductLineUnavailableDate")
public class ProductLineUnavailableDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UnavailableDate", nullable = false)
    private LocalDate unavailableDate;

    @OneToOne
    @MapsId
    @JoinColumn(name = "production_line_id", referencedColumnName = "id")
    private ProductionLine productionLine;
}
