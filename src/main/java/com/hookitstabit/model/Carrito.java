package com.hookitstabit.model;

import lombok.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "compras")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date fecha;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio_total;
}
