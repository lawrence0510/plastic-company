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
@Table(name = "ProductionLine")
public class ProductionLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false, length = 30)
    private String name;

    @Column(name = "DailyProductivity", nullable = false)
    private Integer dailyProductivity;

    @Column(name = "IsAvailable", nullable = false)
    private Boolean isAvailable; // Assuming tinyint(1) is used as a boolean

    @OneToMany(mappedBy = "productionLine")
    private Set<Produce> produces;
}
