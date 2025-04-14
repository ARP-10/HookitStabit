package com.hookitstabit.model;

import lombok.*;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "detalle_compra")
public class Detalle_compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private  int cantidad;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio_unitario;
}
