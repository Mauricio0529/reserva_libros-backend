package com.reserva_libros.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dto del guardado de una reserva. (factura o carrito de compras)
 */
@Getter @Setter
@Builder
@AllArgsConstructor
public class ReservesRequestDto {

    private Integer id;
    private Integer customerCardId;

    /** TOTAL DE CARRITO DE COMPRAS (TOTAL GENERAL),
     * Y EL TOTAL DE CADA UNIDAD VA EN LA LISTA EN EL VIDEO, EN ESTE CASO NO HAY UN VALOR POR UNIDAD**/
    private Integer totalReserves;

    /** fecha de entrega **/
    private LocalDateTime dateDelivery;

    /** fecha de reserva **/
    private LocalDateTime dateReserves;

    /** lista de libros seleccionados para una reserva (carrito)
     * TOCA CORREGIR ESTE DTO, YA QUE ESTE TIENE QUE TENER EL LIBRO(titulo, imagen, etc), cantidad unidad**/
    private List<BookReservesRequestDto> bookReservesEntities;
}