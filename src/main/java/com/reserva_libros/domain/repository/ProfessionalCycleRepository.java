package com.reserva_libros.domain.repository;

import com.reserva_libros.domain.dto.ProfessionalCycleDto;

import java.util.List;
import java.util.Optional;

/**
 * Respositorio de ciclos profesionales
 */

public interface ProfessionalCycleRepository {

    List<ProfessionalCycleDto> getAll();

    Optional<ProfessionalCycleDto> getCycleById(Long id);

    Optional<ProfessionalCycleDto> getCycleByName(String name);

    ProfessionalCycleDto save(ProfessionalCycleDto cycleDto);

    void delete(Long id);
}