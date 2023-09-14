package com.reserva_libros.domain.repository;

import com.reserva_libros.domain.dto.SemesterDto;

import java.util.List;
import java.util.Optional;

/**
 * Respositorio de semestres
 */

public interface SemesterRepository {

    List<SemesterDto> getAll();

    Optional<SemesterDto> getSemesterById(Long id);

    List<SemesterDto> getSemesterByProfessionalCycleId(Long id);

    Optional<SemesterDto> getSemesterByNumberSemester(Integer numberSemester);

    SemesterDto save(SemesterDto semesterDto);

    void delete(Long id);
}