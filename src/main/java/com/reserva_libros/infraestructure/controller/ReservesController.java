package com.reserva_libros.infraestructure.controller;

import com.reserva_libros.domain.dto.ReservesRequestDto;
import com.reserva_libros.domain.dto.ReservesResponseDetailsDto;
import com.reserva_libros.domain.useCase.ReservesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reserva")
@RequiredArgsConstructor
public class ReservesController {

    private final ReservesUseCase reservesUseCase;

    @GetMapping()
    public ResponseEntity<List<ReservesRequestDto>> getAll() {
        return ResponseEntity.ok(reservesUseCase.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservesRequestDto> getById(@PathVariable Integer id) {
        return ResponseEntity.of(reservesUseCase.getById(id));
    }

    // ReservesRequestDto
    @GetMapping("/customer/{cardId}")
    public ResponseEntity<List<ReservesResponseDetailsDto>> getReservesByCardIdCustomer(@PathVariable Integer cardId) {
        return ResponseEntity.ok(reservesUseCase.getByCustomerCardId(cardId));
    }

    // Estado de reserva
    @GetMapping("/status-reserve/{statusReserve}")
    public ResponseEntity<List<ReservesResponseDetailsDto>> getReservesByStatusReserve(@PathVariable String statusReserve) {
        return ResponseEntity.ok(reservesUseCase.getByStatusReserve(statusReserve));
    }

    // ReservesCodeResponseDto
    @PostMapping()
    public ResponseEntity<ReservesResponseDetailsDto> save(@RequestBody ReservesRequestDto reservesRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservesUseCase.save(reservesRequestDto));
    }

    @PutMapping()
    public ResponseEntity<ReservesResponseDetailsDto> update(@RequestBody ReservesRequestDto reservesRequestDto) {
        return ResponseEntity.of(reservesUseCase.update(reservesRequestDto));
    }

    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<ReservesRequestDto> updateStatus(@PathVariable Integer id) {
        return ResponseEntity.of(reservesUseCase.updateStatus(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return new ResponseEntity<>(reservesUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}