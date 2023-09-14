package com.reserva_libros.domain.useCase;

import com.reserva_libros.domain.dto.ProfessionalCareersDto;

import java.util.List;
import java.util.Optional;

public interface ProfessionalCareersService {

    List<ProfessionalCareersDto> getAll();

    Optional<ProfessionalCareersDto> getCareersById(Long id);

    Optional<ProfessionalCareersDto> getCareersByName(String name);

    ProfessionalCareersDto save(ProfessionalCareersDto careersDto);

    Optional<ProfessionalCareersDto> update(ProfessionalCareersDto careersDto);

    boolean delete(Long id);
}