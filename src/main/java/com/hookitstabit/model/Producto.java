package com.hookitstabit.model;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(columnDefinition = "INT DEFAULT 0")
    private int stock;
    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean disponible;
}
