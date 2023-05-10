package com.reserva_libros.infraestructure.controller;

import com.reserva_libros.domain.dto.AuthCustomerDto;
import com.reserva_libros.domain.dto.CustomerDto;
import com.reserva_libros.domain.dto.JwtResponseDto;
import com.reserva_libros.domain.dto.ResponseCustomerDto;
import com.reserva_libros.domain.useCase.CustomerService;
import com.reserva_libros.domain.useCase.AuthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CLASE QUE GENERA EL TOKEN
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final AuthUseCase authUseCase;

    private final CustomerService customerService;

    /**
     * crear un nuevo usuario
     */
    @PostMapping(path = "/register")
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDtoNew) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.save(customerDtoNew));
    }

    /**
     * inicia sesion
     */
    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponseDto> signIn(@RequestBody AuthCustomerDto authCustomerDto) {
        return ResponseEntity.ok(authUseCase.signIn(authCustomerDto));
    }

    /**
     * cerrar sesion
     */
    @PostMapping(path = "/sign-out")
    public ResponseEntity<JwtResponseDto> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        return ResponseEntity.ok(authUseCase.signOut(jwt));
    }
}