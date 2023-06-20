package com.reserva_libros.domain.repository;

import com.reserva_libros.domain.dto.ReservesCodeResponseDto;
import com.reserva_libros.domain.dto.ReservesRequestDto;

import java.util.List;
import java.util.Optional;

/**
 * Respositorio de reserva (compra, carrito compra, factura)
 */
public interface ReservesRepository {

    /**
     * Listar lista de reservas
     * @return Lista de reservas
     */
    List<ReservesRequestDto> getAll();

    /**
     * Obtiene una reserva dada su id
     * @param id Id de reserva
     * @return Optional de reserva encontrada
     */
    Optional<ReservesRequestDto> getById(Integer id);

    /**
     * Guarda una reserva
     * @param reservesRequestDto Reserva a guardar
     * @return Dto de reserva
     */
    ReservesCodeResponseDto save(ReservesRequestDto reservesRequestDto);

    /**
     * Elimina una reserva dada su id
     * @param id Id de reserva
     */
    void delete(Integer id);
}