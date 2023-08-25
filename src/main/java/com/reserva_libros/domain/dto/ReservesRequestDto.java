package com.reserva_libros.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dto del guardado de una reserva. (factura o carrito de compras)
 * FACTURA GENERAL, Historial
 */
@Getter @Setter
@Builder
@AllArgsConstructor
public class ReservesRequestDto {

    private Integer id;
    private Integer customerCardId;

    private Integer totalReserves;

    /** fecha de entrega **/
    private LocalDateTime dateDelivery;

    /** fecha de reserva **/
    private LocalDateTime dateReserves;

    private List<BookReservesRequestDto> bookReservesEntities;
}