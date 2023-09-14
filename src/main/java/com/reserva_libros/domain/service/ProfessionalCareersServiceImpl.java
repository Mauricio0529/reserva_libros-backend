package com.reserva_libros.domain.service;

import com.reserva_libros.domain.dto.ProfessionalCareersDto;
import com.reserva_libros.domain.repository.ProfessionalCareersRepository;
import com.reserva_libros.domain.useCase.ProfessionalCareersService;

import java.util.List;
import java.util.Optional;

public class ProfessionalCareersServiceImpl implements ProfessionalCareersService {

    private final ProfessionalCareersRepository professionalCareersRepository;

    public ProfessionalCareersServiceImpl(ProfessionalCareersRepository professionalCareersRepository) {
        this.professionalCareersRepository = professionalCareersRepository;
    }

    @Override
    public List<ProfessionalCareersDto> getAll() {
        return professionalCareersRepository.getAll();
    }

    @Override
    public Optional<ProfessionalCareersDto> getCareersById(Long id) {
        Optional<ProfessionalCareersDto> professionalCareersDtoOptional = professionalCareersRepository.getCareersById(id);
        if(professionalCareersDtoOptional.isEmpty()) {
            return Optional.empty();
        }
        return professionalCareersDtoOptional;
    }

    @Override
    public Optional<ProfessionalCareersDto> getCareersByName(String name) {
        Optional<ProfessionalCareersDto> professionalCareersDtoOptional = professionalCareersRepository.getCareersByName(name);
        if(professionalCareersDtoOptional.isEmpty()) {
            return Optional.empty();
        }
        return professionalCareersDtoOptional;
    }

    @Override
    public ProfessionalCareersDto save(ProfessionalCareersDto careersDto) {
        Optional<ProfessionalCareersDto> professionalCareersDtoOptional = getCareersByName(careersDto.getName());
        if (professionalCareersDtoOptional.isPresent()) {
            return careersDto;
        }
        professionalCareersRepository.save(careersDto);
        return careersDto;
    }

    @Override
    public Optional<ProfessionalCareersDto> update(ProfessionalCareersDto careersDto) {
        Optional<ProfessionalCareersDto> professionalCareersDtoOptional = getCareersByName(careersDto.getName());
        if (professionalCareersDtoOptional.isEmpty()) {
            return Optional.empty();
        }
        professionalCareersRepository.save(careersDto);
        return Optional.of(careersDto);
    }

    @Override
    public boolean delete(Long id) {
        Optional<ProfessionalCareersDto> professionalCareersDtoOptional = getCareersById(id);
        if (professionalCareersDtoOptional.isEmpty()) {
            return false;
        }
        professionalCareersRepository.delete(id);
        return true;
    }
}