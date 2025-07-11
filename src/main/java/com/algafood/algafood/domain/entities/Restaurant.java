package com.algafood.algafood.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Restaurant {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "tax_fee")
    private int taxFee;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_open")
    private boolean isOpen;

    @ManyToOne
    @JoinColumn(name = "kitchen_id")
    private Kitchen kitchen;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
