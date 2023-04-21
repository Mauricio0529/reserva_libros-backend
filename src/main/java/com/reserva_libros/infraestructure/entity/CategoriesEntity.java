package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad de categorias
 */

@Entity
@Table(name = "categorias")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria;

    @Column(name = "categoria")
    private String nameCategory;
}