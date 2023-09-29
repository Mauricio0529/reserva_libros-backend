package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reservas_libros")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookReservesEntity {

    /**
     * clase compuesta por id
     */

    @EmbeddedId
    private BookReservesPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "title-book")
    private String title;

    @Column(name = "imagePath")
    private String imagePath;

    @Column(name = "author-book")
    private String author;

    @ManyToOne()
    @MapsId(value = "reservesId")
    @JoinColumn(name = "reservascodigo_reserva", insertable = false, updatable = false)
    private ReservesEntity reserves;

    @ManyToOne()
    @JoinColumn(name = "libroscodigo_libro", insertable = false, updatable = false)
    private BookEntity book;


}