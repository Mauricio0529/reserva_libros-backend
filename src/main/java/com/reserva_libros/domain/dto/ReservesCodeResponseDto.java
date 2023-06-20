package com.reserva_libros.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ReservesCodeResponseDto {
    /**
     * Numero de reserva (Numero de factura)
     * CODIGO QR
     */
    private Integer id;

}