package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "reservas_libros")
public class BookReservesEntity {

    /**
     * clase compuesta por id
     */

    @EmbeddedId
    private BookReservesPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    @ManyToOne()
    @MapsId(value = "reservesId")
    @JoinColumn(name = "reservascodigo_reserva", insertable = false, updatable = false)
    private ReservesEntity reserves;


    @ManyToOne()
    @JoinColumn(name = "libroscodigo_libro", insertable = false, updatable = false)
    private ReservesEntity book;
}