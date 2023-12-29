package com.example.digitalbusiness.backend.Model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "Material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @Column(name = "Name", nullable = false, length = 8)
    private String name;

    @Column(name = "Cost", nullable = false)
    private Integer cost;

    @Column(name = "Inventory", nullable = false)
    private Integer inventory;

    @OneToMany(mappedBy = "material")
    @JsonIgnore
    private Set<Assemble> assembles;
}