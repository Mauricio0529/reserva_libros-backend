package com.reserva_libros.infraestructure.controller;

import com.reserva_libros.domain.dto.ReservesCodeResponseDto;
import com.reserva_libros.domain.dto.ReservesRequestDto;
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

    @PostMapping()
    public ResponseEntity<ReservesCodeResponseDto> save(@RequestBody ReservesRequestDto reservesRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservesUseCase.save(reservesRequestDto));
    }

    @PatchMapping()
    public ResponseEntity<ReservesCodeResponseDto> update(@RequestBody ReservesRequestDto reservesRequestDto) {
        return ResponseEntity.of(reservesUseCase.update(reservesRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return new ResponseEntity<>(reservesUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}