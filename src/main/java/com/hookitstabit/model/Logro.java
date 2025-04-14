package com.hookitstabit.model;

import lombok.*;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "logros")
public class Logro {
    public enum tipoLogro {
        DESCUENTO, MEDALLA, PATRON
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Lob
    private String descripcion;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private tipoLogro tipo;
    @Column(columnDefinition = "DECIMAL(10,2) DEFAULT 0.00")
    private BigDecimal recompensa;
}
