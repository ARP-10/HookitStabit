package com.hookitstabit.model;

import jakarta.validation.constraints.*;
import lombok.*;
import jakarta.persistence.*;

import java.math.BigDecimal;

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
    @Size(max = 100, message = "El nombre no puede tener mas de 100 caracteres")
    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Column(columnDefinition = "INT DEFAULT 0")
    private int stock;
    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean disponible;
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio no puede ser negativo")
    @NotNull(message = "El precio es obligatorio")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;
}
