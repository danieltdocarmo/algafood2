package com.algafood.algafood.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "kitchen")
@Data
public class Kitchen {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
