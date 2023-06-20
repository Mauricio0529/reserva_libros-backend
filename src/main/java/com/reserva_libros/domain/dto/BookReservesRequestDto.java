package com.reserva_libros.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto del guardado de los libros de una reserva
 */

@Getter @Setter
@AllArgsConstructor
public class BookReservesRequestDto {

    /**
     * Detalle compra
     * detalle del carrito
     */
    private Integer reservesId; // ESTO SOBRA
    private Integer bookId;
    private Integer quantity; /** unidad */
}
