package com.reserva_libros.infraestructure.controller;

import com.reserva_libros.domain.dto.*;
import com.reserva_libros.domain.useCase.CustomerService;
import com.reserva_libros.domain.useCase.AuthUseCase;
import com.reserva_libros.domain.useCase.EmailPort;
import com.reserva_libros.domain.useCase.GenerateCodeToEmail;
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

    private final EmailPort emailPort;

    private final GenerateCodeToEmail generateCodeToEmail;

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

    /**
     * Envía email, retorne el codigo
     * Time -> 12.77 s
     * Size -> 427 B
     */
    @GetMapping(path = "/send-email/{newEmailRequestDto}")
    public ResponseEntity<CustomerDto> sendEmail(@PathVariable String newEmailRequestDto) {
        //return new ResponseEntity<>(emailPort.sendEmail(newEmailRequestDto) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(emailPort.sendEmail(newEmailRequestDto));
    }

    /** BORRAR ESTE
     * Validar el codigo ingresado con el codigo de email
     * @return true si el codigo ingresado es el correcto
     */
    @GetMapping(path = "/validate-code-email")
    public ResponseEntity<Boolean> validateCodeToEmail(@RequestBody EmailCodeDto newCodeRequestDto) {
        //return new ResponseEntity<>(generateCodeToEmail.randomCodeToEmailValidate(newCodeRequestDto) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(generateCodeToEmail.randomCodeToEmailValidate(newCodeRequestDto));
    }

    /**
     * Actualizar contraseña de un usuario
     * @param customerDtoNew Usuario a modificar
     * @return Contraseña nueva
     */
    @PatchMapping(path = "/update-password-customer")
    public ResponseEntity<ResponseCustomerDto> customerPasswordUpdate(@RequestBody CustomerDto customerDtoNew) {
        //ResponseCustomerDto responseCustomerDto = new ResponseCustomerDto(customerService.update(customerDtoNew).get().getPassword());
        return ResponseEntity.ok(emailPort.customerPasswordUpdate(customerDtoNew));
    }

    /**
     @Override
     public ResponseCustomerDto customerPasswordUpdate(CustomerDto newCustomerDto) {

     CustomerDto customerResponseDto = new CustomerDto();
     String newPassword = newCustomerDto.getPassword();

     newCustomerDto.setPassword(passwordEncoder.encode(newPassword));

     customerResponseDto.setCardId(newCustomerDto.getCardId());
     customerResponseDto.setName(newCustomerDto.getName());
     customerResponseDto.setLestName(newCustomerDto.getLestName());
     customerResponseDto.setUsername(newCustomerDto.getUsername());
     customerResponseDto.setPassword(newCustomerDto.getPassword()); // password
     customerResponseDto.setEmail(newCustomerDto.getEmail());
     //customerResponseDto.setActive(1); Customer
     //customerResponseDto.setRol("Customer");
     customerResponseDto.setNumberCellPhone(newCustomerDto.getNumberCellPhone());


     customerRepository.save(customerResponseDto);

     return new ResponseCustomerDto(newPassword);
     }
     */
}