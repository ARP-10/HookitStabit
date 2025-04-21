package com.hookitstabit.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(max = 25, message = "El nombre no puede tener mas de 25 caracteres")
    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 25)
    private String nombre;
}
