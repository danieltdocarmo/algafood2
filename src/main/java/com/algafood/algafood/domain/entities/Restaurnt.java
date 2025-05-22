package com.algafood.algafood.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
public class Restaurnt {
    
    @Id
    @GeneratedValue(strategy = GeneratedType.IDENTITY)
    private String id;

    @Column()
    private long taxFee;

    @Column()
    private boolean isActive;

    @Column()
    private boolean isOpen;

    @Column()
    private Timestamp createdAt;

    @Column()
    private Timestamp updatedAt;
}
