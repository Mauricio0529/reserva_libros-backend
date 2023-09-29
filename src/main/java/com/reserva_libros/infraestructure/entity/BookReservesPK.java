package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class BookReservesPK implements Serializable {

    @Serial
    private static final long serialVersionUID = -2145479604343286721L;

    @Column(name = "reservascodigo_reserva")
    private Integer reservesId;

    @Column(name = "libroscodigo_libro")
    private Integer bookId;
}