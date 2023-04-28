package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "libros")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_libro")
    private Integer bookId;

    @Column(name = "autorid")
    private Integer authorId;

    @Column(name = "categoriasid")
    private Integer categoryId;

    @Column(name = "titulo")
    private String title;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "imagen")
    private String imagePath;

    @Column(name = "anio_publicacion")
    private Integer yearOfPublication;

    @Column(name = "estado_activo")
    private Integer active;

    @ManyToOne
    @JoinColumn(name = "autorid", insertable = false, updatable = false)
    private AuthorEntity authors;

    @ManyToOne()
    @JoinColumn(name = "categoriasid", insertable = false, updatable = false)
    private CategoriesEntity category;

}