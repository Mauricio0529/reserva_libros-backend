package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private List<BookEntity> bookEntities;
}