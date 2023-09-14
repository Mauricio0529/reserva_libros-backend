package com.reserva_libros.infraestructure.controller;

import com.reserva_libros.domain.dto.SemesterDto;
import com.reserva_libros.domain.useCase.SemesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/semester")
@RequiredArgsConstructor
public class SemesterController {

    private final SemesterService semesterService;

    @GetMapping()
    public ResponseEntity<List<SemesterDto>> getAll() {
        return ResponseEntity.ok(semesterService.getAll());
    }

    @GetMapping("/get-id")
    public ResponseEntity<SemesterDto> getById(@RequestParam Long id) {
        return ResponseEntity.of(semesterService.getSemesterById(id));
    }

    @GetMapping("/get-cycle")
    public ResponseEntity<List<SemesterDto>> getSemesterByCycleId(@RequestParam Long professionalCycle) {
        List<SemesterDto> semesterDtoList = semesterService.getSemesterByProfessionalCycleId(professionalCycle);

        if(semesterDtoList == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(semesterService.getSemesterByProfessionalCycleId(professionalCycle));
    }

    @GetMapping("/get-number-semester")
    public ResponseEntity<SemesterDto> getByNumberSemester(@RequestParam Integer numberSemester) {
        return ResponseEntity.of(semesterService.getSemesterByNumberSemester(numberSemester));
    }

    @PostMapping()
    public ResponseEntity<SemesterDto> save(@RequestBody SemesterDto newSemester) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(semesterService.save(newSemester));
    }

    @PatchMapping()
    public ResponseEntity<SemesterDto> update(@RequestBody SemesterDto updateSemester) {
        return ResponseEntity.of(semesterService.update(updateSemester));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@RequestParam Long id) {
        return new ResponseEntity<>(semesterService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}