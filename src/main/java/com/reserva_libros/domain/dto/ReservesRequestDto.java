package com.reserva_libros.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dto del guardado de una reserva
 */
public class ReservesRequestDto {

    private Integer id;
    private Integer customerCardId;
    private Integer totalReserves;
    private LocalDateTime dateDelivery;
    private LocalDateTime dateReserves;

    private List<BooksReservesRequestDto> booksReserves;
}