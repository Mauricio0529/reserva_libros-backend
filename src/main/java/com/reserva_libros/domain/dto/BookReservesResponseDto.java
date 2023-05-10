package com.reserva_libros.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookReservesResponseDto {

    private String title;

    private Integer quantity;
}
