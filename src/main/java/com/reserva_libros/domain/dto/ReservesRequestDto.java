package com.reserva_libros.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dto del guardado de una reserva. (factura o carrito de compras)
 * FACTURA GENERAL
 */
@Getter @Setter
@Builder
@AllArgsConstructor
public class ReservesRequestDto {

    private Integer id;
    private Integer customerCardId;

    /** TOTAL DE CARRITO DE COMPRAS (TOTAL GENERAL),
     * Y EL TOTAL DE CADA UNIDAD VA EN LA LISTA EN EL VIDEO, EN ESTE CASO NO HAY UN VALOR POR UNIDAD**/
    /**
     * SUMA TOTAL DEL NUMERO DE CANTIDADES DE LIBRO POR UNIDAD
     * EJ:
     *       LIRBO              CANTIDAD
     * La tecnologia avanza.       2
     * La cronica de ciencia       1
     *                        _____________
     * TOTAL                       3
     *
     * PERO EN ESTE PROYECTO NO APLICA DE ESA MANERA, YA QUE EL LIBRO SOLO HAY UNA SOLA UNIDAD,
     * ENTONCES EL LIBRO QUE SE AGREGA YA NO SERA MOSTRADO EN EL CATALOGO.
     *
     * ESTA VARIABLE SOBRARIA,O REEMPLAZARLA POR EL TOTAL DE NUMERO DE LIBROS QUE HAYA EN LA RESERVA
     *
     *       LIRBO              CANTIDAD
     *      * La tecnologia avanza.       1
     *      * La cronica de ciencia       1
     *      *                        _____________
     *      * TOTAL                       2
     *
     *      O
     *            LIRBO
     *      * La tecnologia avanza.
     *      * La cronica de ciencia
     *      *
     *      * TOTAL DE LIBROS: 2
     */
    private Integer totalReserves; // TOTAL GENERAL (SUMA TOTAL DE TODOS LOS PRECIOS DE LOS CARROS QUE HAY EN EL CARRITO DE COMPRAS)

    /** fecha de entrega **/
    private LocalDateTime dateDelivery;

    /** fecha de reserva **/
    private LocalDateTime dateReserves;

    /** lista de libros seleccionados para una reserva (carrito)
     * TOCA CORREGIR ESTE DTO, YA QUE ESTE TIENE QUE TENER EL LIBRO(titulo, imagen, etc), cantidad unidad**/
    private List<BookReservesRequestDto> bookReservesEntities;
}