package com.reserva_libros.domain.service;

import com.reserva_libros.domain.dto.ReservesCodeResponseDto;
import com.reserva_libros.domain.dto.ReservesRequestDto;
import com.reserva_libros.domain.repository.ReservesRepository;
import com.reserva_libros.domain.useCase.ReservesUseCase;

import java.util.List;
import java.util.Optional;

public class ReservesServiceImpl implements ReservesUseCase {

    private final ReservesRepository reservesRepository;

    public ReservesServiceImpl(ReservesRepository reservesRepository) {
        this.reservesRepository = reservesRepository;
    }

    @Override
    public List<ReservesRequestDto> getAll() {
        return reservesRepository.getAll();
    }

    @Override
    public Optional<ReservesRequestDto> getById(Integer idReserves) {
        Optional<ReservesRequestDto> reservesRequestDto = reservesRepository.getById(idReserves);
        if(reservesRequestDto.isPresent()) {
            return reservesRequestDto;
        }
        return Optional.empty();
    }

    @Override
    public ReservesCodeResponseDto save(ReservesRequestDto reservesRequestDto) {
        return reservesRepository.save(reservesRequestDto);
    }

    @Override
    public Optional<ReservesCodeResponseDto> update(ReservesRequestDto reservesRequestDto) {
        if(reservesRepository.getById(reservesRequestDto.getId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(reservesRepository.save(reservesRequestDto));
    }

    @Override
    public boolean delete(Integer idReserves) {
        if(reservesRepository.getById(idReserves).isEmpty()) {
            return false;
        }

        reservesRepository.delete(idReserves);
        return true;
    }
}