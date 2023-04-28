package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entidad de autor
 */

@Entity
@Table(name = "autor")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {

    /**
     * id de autor
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * nombre de autor
     */
    @Column(name = "nombre")
    private String name;

    @OneToMany(mappedBy = "authors", orphanRemoval = true)
    private List<BookEntity> bookEntities;
}