package com.reserva_libros.infraestructure.controller;

import com.reserva_libros.domain.dto.ProfessionalCycleDto;
import com.reserva_libros.domain.useCase.ProfessionalCycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/professional-cycle")
@RequiredArgsConstructor
public class ProfessionalCycleController {

    private final ProfessionalCycleService professionalCycleService;

    @GetMapping()
    public ResponseEntity<List<ProfessionalCycleDto>> getAll() {
        return ResponseEntity.ok(professionalCycleService.getAll());
    }

    @GetMapping("/get-id")
    public ResponseEntity<ProfessionalCycleDto> getById(@RequestParam Long id) {
        return ResponseEntity.of(professionalCycleService.getCycleById(id));
    }

    @GetMapping("/get-name")
    public ResponseEntity<ProfessionalCycleDto> getCycleByName(@RequestParam String name) {
        return ResponseEntity.of(professionalCycleService.getCycleByName(name));
    }

    @PostMapping()
    public ResponseEntity<ProfessionalCycleDto> save(@RequestBody ProfessionalCycleDto newProfessionalCycle) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(professionalCycleService.save(newProfessionalCycle));
    }

    @PatchMapping()
    public ResponseEntity<ProfessionalCycleDto> update(@RequestBody ProfessionalCycleDto updateProfessionalCycle) {
        return ResponseEntity.of(professionalCycleService.update(updateProfessionalCycle));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@RequestParam Long id) {
        return new ResponseEntity<>(professionalCycleService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}