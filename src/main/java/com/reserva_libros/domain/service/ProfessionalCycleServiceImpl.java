package com.reserva_libros.domain.service;

import com.reserva_libros.domain.dto.ProfessionalCycleDto;
import com.reserva_libros.domain.repository.ProfessionalCycleRepository;
import com.reserva_libros.domain.useCase.ProfessionalCycleService;

import java.util.List;
import java.util.Optional;

public class ProfessionalCycleServiceImpl implements ProfessionalCycleService {

    private final ProfessionalCycleRepository professionalCycleRepository;

    public ProfessionalCycleServiceImpl(ProfessionalCycleRepository professionalCycleRepository) {
        this.professionalCycleRepository = professionalCycleRepository;
    }

    @Override
    public List<ProfessionalCycleDto> getAll() {
        return professionalCycleRepository.getAll();
    }

    @Override
    public Optional<ProfessionalCycleDto> getCycleById(Long id) {
        Optional<ProfessionalCycleDto> professionalCycleDtoOptional = professionalCycleRepository.getCycleById(id);
        if(professionalCycleDtoOptional.isEmpty()) {
            return Optional.empty();
        }
        return professionalCycleDtoOptional;
    }

    @Override
    public Optional<ProfessionalCycleDto> getCycleByName(String name) {
        Optional<ProfessionalCycleDto> professionalCycleDtoOptional = professionalCycleRepository.getCycleByName(name);
        if(professionalCycleDtoOptional.isEmpty()) {
            return Optional.empty();
        }
        return professionalCycleDtoOptional;
    }

    @Override
    public ProfessionalCycleDto save(ProfessionalCycleDto cycleDto) {
        Optional<ProfessionalCycleDto> professionalCycleDtoOptional = getCycleByName(cycleDto.getName());
        if (professionalCycleDtoOptional.isPresent()) {
            return cycleDto;
        }
        professionalCycleRepository.save(cycleDto);
        return cycleDto;
    }

    @Override
    public Optional<ProfessionalCycleDto> update(ProfessionalCycleDto cycleDto) {
        Optional<ProfessionalCycleDto> professionalCycleDtoOptional = getCycleByName(cycleDto.getName());
        if (professionalCycleDtoOptional.isEmpty()) {
            return Optional.empty();
        }
        professionalCycleRepository.save(cycleDto);
        return Optional.of(cycleDto);
    }

    @Override
    public boolean delete(Long id) {
        Optional<ProfessionalCycleDto> professionalCycleDtoOptional = getCycleById(id);
        if (professionalCycleDtoOptional.isEmpty()) {
            return false;
        }
        professionalCycleRepository.delete(id);
        return true;
    }
}