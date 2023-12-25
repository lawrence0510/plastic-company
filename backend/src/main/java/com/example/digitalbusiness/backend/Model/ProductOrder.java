package com.example.digitalbusiness.backend.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ProductOrder")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Date", nullable = false)
    private LocalDateTime date;

    @JsonIgnore
    @Column(name = "Status", nullable = false)
    private String status; // "complete" or "processing"

    @Column(name = "Progress", nullable = true)
    private double progress;

    @OneToOne
    @JoinColumn(name = "Produce_id")
    private Produce produce;

    @ManyToOne
    @JoinColumn(name = "Customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "Product_id")
    private Product product;

    @PrePersist
    protected void onCreate() {
        date = LocalDateTime.now();
    }
}
