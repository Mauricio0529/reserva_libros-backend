package com.reserva_libros.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto del guardado de los libros de una reserva
 * Detalle reserva
 */

@Getter @Setter
@AllArgsConstructor
public class BookReservesRequestDto {

    // NUMERO DE REFERENCIA DE RESERVA
    private Integer reservesId;
    private Integer bookId;
    private Integer quantity;
    private String title;
    private String imagePath;
    private String author;

}