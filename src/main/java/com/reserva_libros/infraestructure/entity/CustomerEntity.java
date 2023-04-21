package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad de usuario
 */

@Getter @Setter
@Entity
@Table(name = "usuarios")
public class CustomerEntity {

    @Id
    @Column(name = "cedula")
    private Integer cardId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellidos")
    private String surnames;

    @Column(name = "nombre_usuario")
    private String username;

    @Column(name = "contrasena")
    private String password;

    @Column(name = "correo")
    private String email;

    @Column(name = "numero_celular")
    private Integer numberCellPhone;
}
