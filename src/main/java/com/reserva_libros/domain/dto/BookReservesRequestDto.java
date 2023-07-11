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

    /** CARRITO DE COMPRAS ***
     *
     * ESTE AGREGARIA LOS LIBROS AL CARRITO DE COMPRAS
     *
     * ESTE AGREGARIA LOS LIBROS QUE SELECCIONO PARA EL CARRITO DE COMPRAS
     */

    private Integer reservesId; // NUMERO DE FACTURA, NUMERO DE REFERENCIA DE RESERVA
    private Integer bookId;
    private Integer quantity; /** unidad */
    private String title;
    private String imagePath;

    /**
     * private String title;
     * private String imgPath;
     */
}
