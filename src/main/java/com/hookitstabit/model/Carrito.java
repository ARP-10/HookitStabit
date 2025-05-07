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
@Table(name = "carrito")
public class Carrito {

    public enum EstadoCarrito {
        ABIERTO,
        FINALIZADO,
        CANCELADO
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date fecha;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio_total;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCarrito estado;
}
// llamar transaccion a la compra/venta
//en detalle compra meter el nombre de producto y quitar la relacion (venta seria como una factura)
