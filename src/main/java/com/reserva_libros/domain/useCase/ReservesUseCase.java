package com.reserva_libros.domain.useCase;

import com.reserva_libros.domain.dto.ReservesRequestDto;
import com.reserva_libros.domain.dto.ReservesResponseDetailsDto;

import java.util.List;
import java.util.Optional;

public interface ReservesUseCase {

    List<ReservesRequestDto> getAll();

    Optional<ReservesRequestDto> getById(Integer idReserves);

    List<ReservesResponseDetailsDto> getByCustomerCardId(Integer cardId);

    List<ReservesResponseDetailsDto> getByStatusReserve(String statusReserve);

    ReservesResponseDetailsDto save(ReservesRequestDto reservesRequestDto);

    Optional<ReservesResponseDetailsDto> update(ReservesRequestDto reservesRequestDto);

    Optional<ReservesRequestDto> updateStatus(Integer id);

    boolean delete(Integer idReserves);
}