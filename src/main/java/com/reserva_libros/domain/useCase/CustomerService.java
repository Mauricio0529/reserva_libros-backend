package com.reserva_libros.domain.useCase;

import com.reserva_libros.domain.dto.CustomerDto;
import com.reserva_libros.domain.dto.ResponseCustomerDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerByCardId(Integer cardId);

    Optional<CustomerDto> getCustomerByUserName(String username);

    Optional<CustomerDto> getCustomerByEmail(String email);

    ResponseCustomerDto save(CustomerDto customerDto);

    Optional<CustomerDto> update(CustomerDto customerDto);

    Optional<CustomerDto> updateByEmail(CustomerDto customerDto);

    boolean deleteById(Integer cardId);

    boolean deleteByUserName(String username);

    boolean deleteByEmail(String emil);
}