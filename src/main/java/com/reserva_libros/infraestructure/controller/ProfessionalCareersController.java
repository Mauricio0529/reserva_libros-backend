package com.reserva_libros.infraestructure.controller;

import com.reserva_libros.domain.dto.ProfessionalCareersDto;
import com.reserva_libros.domain.useCase.ProfessionalCareersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/professional-careers")
@RequiredArgsConstructor
public class ProfessionalCareersController {

    private final ProfessionalCareersService professionalCareersService;

    @GetMapping()
    public ResponseEntity<List<ProfessionalCareersDto>> getAll() {
        return ResponseEntity.ok(professionalCareersService.getAll());
    }

    @GetMapping("/get-id")
    public ResponseEntity<ProfessionalCareersDto> getById(@RequestParam Long id) {
        return ResponseEntity.of(professionalCareersService.getCareersById(id));
    }

    @GetMapping("/get-name-careers")
    public ResponseEntity<ProfessionalCareersDto> getCareersByName(@RequestParam String name) {
        return ResponseEntity.of(professionalCareersService.getCareersByName(name));
    }

    @PostMapping()
    public ResponseEntity<ProfessionalCareersDto> save(@RequestBody ProfessionalCareersDto newProfessionalCareers) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(professionalCareersService.save(newProfessionalCareers));
    }

    @PatchMapping()
    public ResponseEntity<ProfessionalCareersDto> update(@RequestBody ProfessionalCareersDto updateProfessionalCareers) {
        return ResponseEntity.of(professionalCareersService.update(updateProfessionalCareers));
    }

    @DeleteMapping("/delete-id")
    public ResponseEntity<Boolean> deleteById(@RequestParam Long id) {
        return new ResponseEntity<>(professionalCareersService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}