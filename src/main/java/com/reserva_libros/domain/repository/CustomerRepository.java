package com.reserva_libros.domain.repository;

import com.reserva_libros.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;


/**
 * Respositorio de usuario
 */

public interface CustomerRepository {

    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerByCardId(Integer cardId);

    Optional<CustomerDto> getCustomerByUserName(String username);

    Optional<CustomerDto> getCustomerByEmail(String email);

    CustomerDto save(CustomerDto customerDto);

    void delete(Integer cardId);
}