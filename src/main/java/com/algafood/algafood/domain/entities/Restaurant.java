package com.algafood.algafood.domain.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Restaurant {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;

    @Column
    private String name;

    @Column(name = "tax_fee")
    private long taxFee;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_open")
    private boolean isOpen;

    @Column()
    private LocalDateTime createdAt;

    @Column()
    private LocalDateTime updatedAt;
}
