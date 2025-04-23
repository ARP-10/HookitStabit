package com.hookitstabit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(max = 25, message = "El nombre no puede tener mas de 25 caracteres")
    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false)
    private String nombre;
    @NotBlank(message = "El email es obligatorio")
    @Size(max = 100, message = "El email no puede tener mas de 100 caracteres")
    @Column(nullable = false, length = 100)
    @jakarta.validation.constraints.Email
    private String email;
    @NotBlank(message = "La contraseña es obligatoria")
    @Column(nullable = false)
    private String password;

    @Override
    public String toString() {
        return "Usuario{" +
                "ID: " + id +
                ", Nombre: " + nombre + '\'' +
                ", Email: " + email + '\'' +
                ", Password: " + password + '\'' +
                '}';
    }
}
