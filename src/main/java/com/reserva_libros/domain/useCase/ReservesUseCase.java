package com.reserva_libros.domain.useCase;

import com.reserva_libros.domain.dto.ReservesCodeResponseDto;
import com.reserva_libros.domain.dto.ReservesRequestDto;

import java.util.List;
import java.util.Optional;

public interface ReservesUseCase {

    List<ReservesRequestDto> getAll(); //

    Optional<ReservesRequestDto> getById(Integer idReserves);

    List<ReservesRequestDto> getByCustomerCardId(Integer cardId);

    ReservesCodeResponseDto save(ReservesRequestDto reservesRequestDto);

    Optional<ReservesCodeResponseDto> update(ReservesRequestDto reservesRequestDto);

    boolean delete(Integer idReserves);
}