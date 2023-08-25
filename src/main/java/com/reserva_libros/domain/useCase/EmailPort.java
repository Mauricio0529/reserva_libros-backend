package com.reserva_libros.domain.useCase;

import com.reserva_libros.domain.dto.CustomerDto;
import com.reserva_libros.domain.dto.ResponseCustomerDto;

public interface EmailPort {

    /**
     * Enviar codigo de recuperacion por medio de email
     */
    CustomerDto sendEmail(String emailRequestDto);

    ResponseCustomerDto customerPasswordUpdate(CustomerDto customerDto);

}