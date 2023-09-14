package com.reserva_libros.domain.useCase;

import com.reserva_libros.domain.dto.SemesterDto;

import java.util.List;
import java.util.Optional;

public interface SemesterService {

    List<SemesterDto> getAll();

    Optional<SemesterDto> getSemesterById(Long id);

    List<SemesterDto> getSemesterByProfessionalCycleId(Long id);

    Optional<SemesterDto> getSemesterByNumberSemester(Integer numberSemester);

    SemesterDto save(SemesterDto semesterDto);

    Optional<SemesterDto> update(SemesterDto semesterDto);

    boolean delete(Long id);
}
