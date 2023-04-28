package com.reserva_libros.infraestructure.controller;

import com.reserva_libros.domain.dto.CustomerDto;
import com.reserva_libros.domain.dto.ResponseCustomerDto;
import com.reserva_libros.domain.useCase.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getAll() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<CustomerDto> getById(@PathVariable Integer cardId) {
        return ResponseEntity.of(customerService.getCustomerByCardId(cardId));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<CustomerDto> getByUserName(@PathVariable String username) {
        return ResponseEntity.of(customerService.getCustomerByUserName(username));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerDto> getByEmail(@PathVariable String email) {
        return ResponseEntity.of(customerService.getCustomerByEmail(email));
    }

    @PostMapping()
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.save(customerDto));
    }

    @PatchMapping()
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.of(customerService.update(customerDto));
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer cardId) {
        return new ResponseEntity<>(customerService.deleteById(cardId), HttpStatus.OK);
    }

    @DeleteMapping("/username/{username}")
    public ResponseEntity<Boolean> deleteByUserName(@PathVariable String username) {
        return new ResponseEntity<>(customerService.deleteByUserName(username), HttpStatus.OK);
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity<Boolean> deleteByEmail(@PathVariable String email) {
        return new ResponseEntity<>(customerService.deleteByEmail(email), HttpStatus.OK);
    }


}