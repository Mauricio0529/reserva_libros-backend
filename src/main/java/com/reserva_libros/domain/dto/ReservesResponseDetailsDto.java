package com.reserva_libros.domain.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dto para detalle de la reserva
 */
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservesResponseDetailsDto {

    private Integer id;
    private Integer customerCardId;

    private Integer totalReserves;

    private String professionalCareers;
    private String professionalCycle;
    private Integer semester;

    /** fecha de entrega **/
    private LocalDateTime dateDelivery;

    /** fecha de reserva **/
    private LocalDateTime dateReserves;

    private List<BookReservesRequestDto> bookReservesEntities;
}