package com.reserva_libros.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dto de la consulta de una reserva
 */
public class ReservesResponseDto {
    private Integer id;
    private Integer customerCardId;
    private Integer totalReserves;
    private LocalDateTime dateDelivery;
    private LocalDateTime dateReserves;

    private List<BooksReservesResponseDto> booksReserves;
}
