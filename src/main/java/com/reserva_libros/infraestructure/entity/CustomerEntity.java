package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    private String lestName;

    @Column(name = "nombre_usuario")
    private String username;

    @Column(name = "contrasena")
    private String password;

    @Column(name = "correo")
    private String email;

    @Column(name = "activo")
    private Integer active;

    private String rol;

    @Column(name = "numero_celular")
    private Double numberCellPhone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) //
    private List<ReservesEntity> reservesEntity;
}