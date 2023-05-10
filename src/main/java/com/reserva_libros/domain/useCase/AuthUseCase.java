package com.reserva_libros.domain.useCase;

import com.reserva_libros.domain.dto.AuthCustomerDto;
import com.reserva_libros.domain.dto.JwtResponseDto;

/**
    Caso de uso login usuario
 */

public interface AuthUseCase {

    JwtResponseDto signIn(AuthCustomerDto authCustomerDto);

    JwtResponseDto signOut(String jwt);
}