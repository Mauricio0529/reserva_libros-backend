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

    /**
     * Detalle compra
     * detalle del carrito
     * AQUI SE MOSTRARIA CUANTOS DIAS SE DA EL PLAZO PARA ENTREGAR LOS LIBROS
     *
     *
     * ESTE SERIA VER EL CARRITO
     * descripcion, titulo, cantidad unidad, OPCIONAL (imagen, fecha de reserva)
     */

    private String title;

    private Integer quantity;
}
