package com.reserva_libros.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookReservesRequestDto {

    private Integer reservesId;
    private Integer bookId;
    private Integer quantity;
}
