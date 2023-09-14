package com.reserva_libros.domain.repository;

import com.reserva_libros.domain.dto.ReservesRequestDto;
import com.reserva_libros.domain.dto.ReservesResponseDetailsDto;

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
     * Obtiene reserva dada el id (cedula) de un usuario
     * @param cardId Cedula de usuario
     * @return Optional de reserva encontrada de un usuario
     */
    List<ReservesResponseDetailsDto> getByCardIdCustomer(Integer cardId);

    /**
     * Guarda una reserva
     * @param reservesRequestDto Reserva a guardar
     * @return Dto de reserva
     */
    ReservesResponseDetailsDto save(ReservesRequestDto reservesRequestDto);

    /**
     * Elimina una reserva dada su id
     * @param id Id de reserva
     */
    void delete(Integer id);
}