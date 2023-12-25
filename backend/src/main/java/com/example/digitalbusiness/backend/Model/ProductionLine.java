package com.example.digitalbusiness.backend.Model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
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

    @OneToMany(mappedBy = "productionLine")
    private Set<Produce> produces;

    @OneToOne(mappedBy = "productionLine", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ProductLineUnavailableDate productLineUnavailableDate;
}
