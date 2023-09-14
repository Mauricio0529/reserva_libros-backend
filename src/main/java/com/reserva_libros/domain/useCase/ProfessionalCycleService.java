package com.reserva_libros.domain.useCase;

import com.reserva_libros.domain.dto.ProfessionalCycleDto;

import java.util.List;
import java.util.Optional;

public interface ProfessionalCycleService {

    List<ProfessionalCycleDto> getAll();

    Optional<ProfessionalCycleDto> getCycleById(Long id);

    Optional<ProfessionalCycleDto> getCycleByName(String name);

    ProfessionalCycleDto save(ProfessionalCycleDto cycleDto);

    Optional<ProfessionalCycleDto> update(ProfessionalCycleDto cycleDto);

    boolean delete(Long id);
}