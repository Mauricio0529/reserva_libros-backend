package com.reserva_libros.domain.repository;

import com.reserva_libros.domain.dto.ProfessionalCareersDto;

import java.util.List;
import java.util.Optional;

/**
 * Respositorio de carreras profesionales
 */

public interface ProfessionalCareersRepository {

    List<ProfessionalCareersDto> getAll();

    Optional<ProfessionalCareersDto> getCareersById(Long id);

    Optional<ProfessionalCareersDto> getCareersByName(String name);

    ProfessionalCareersDto save(ProfessionalCareersDto careersDto);

    void delete(Long id);
}