package com.reserva_libros.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto de consulta de los libros de una reserva
 */

@Getter @Setter
@AllArgsConstructor
public class BookReservesResponseDto {


    private String title;

    private Integer quantity;

}
