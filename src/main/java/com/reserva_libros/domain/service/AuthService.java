package com.reserva_libros.domain.service;

import com.reserva_libros.domain.dto.AuthCustomerDto;
import com.reserva_libros.domain.dto.CustomerDto;
import com.reserva_libros.domain.dto.JwtResponseDto;
import com.reserva_libros.domain.repository.CustomerRepository;
import com.reserva_libros.domain.useCase.AuthUseCase;
import com.reserva_libros.infraestructure.exception.CustomerNotExistException;
import com.reserva_libros.infraestructure.exception.PasswordIncorrectException;
import com.reserva_libros.security.JwtAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

/**
 * Servicio encargado del logueo de un usuario
 */

public class AuthService implements AuthUseCase {

    private final CustomerRepository customerRepository;

    /**
     * Clase que administra los JWTs
     */
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    /**
     * Clase que encripta contraseñas
     */
    private final PasswordEncoder passwordEncoder;

    public AuthService(CustomerRepository customerRepository,
                       JwtAuthenticationProvider jwtAuthenticationProvider,
                       PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Inicia sesion.
     * Devuelve un dto con el jwt del usuario dadas unas credenciales
     * @param authCustomerDto Credenciales de acceso
     * @return Dto con el jwt del usuario si las credenciales son validas
     */
    public JwtResponseDto signIn(AuthCustomerDto authCustomerDto) {

        Optional<CustomerDto> customer = customerRepository.getCustomerByEmail(authCustomerDto.getEmail());

        if (customer.isEmpty()) {
            throw new CustomerNotExistException();
        }

        /**
         * match para comparar la contraseña
         */
        if (!passwordEncoder.matches(authCustomerDto.getPassword(), customer.get().getPassword())) {
            throw new PasswordIncorrectException();
        }


        return new JwtResponseDto(jwtAuthenticationProvider.createToken(customer.get()));
    }

    /**
     * Cierra la sesión eliminando de la lista blanca el token ingresado
     * @param token Token a eliminar
     * @return
     */
    public JwtResponseDto signOut(String token) {

        String[] authElements = token.split(" ");
        return new JwtResponseDto(jwtAuthenticationProvider.deleteToken(authElements[1]));
    }
}
