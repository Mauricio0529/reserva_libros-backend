package com.reserva_libros.infraestructure.repositoryImpl;

import com.reserva_libros.domain.dto.ProfessionalCareersDto;
import com.reserva_libros.domain.repository.ProfessionalCareersRepository;
import com.reserva_libros.infraestructure.crud.ProfessionalCareersCrudRepository;
import com.reserva_libros.infraestructure.entity.ProfessionalCareersEntity;
import com.reserva_libros.infraestructure.mapper.MapperProfessionalCareers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProfessionalCareersRepositoryImpl implements ProfessionalCareersRepository {

    private final ProfessionalCareersCrudRepository professionalCareersCrudRepository;
    private final MapperProfessionalCareers mapperProfessionalCareers;

    @Override
    public List<ProfessionalCareersDto> getAll() {
        return mapperProfessionalCareers.toListDto(professionalCareersCrudRepository.findAll());
    }

    @Override
    public Optional<ProfessionalCareersDto> getCareersById(Long id) {
        return professionalCareersCrudRepository.findById(id).map(mapperProfessionalCareers::toDto);
    }

    @Override
    public Optional<ProfessionalCareersDto> getCareersByName(String name) {
        return professionalCareersCrudRepository.findByName(name).map(mapperProfessionalCareers::toDto);
    }

    @Override
    public ProfessionalCareersDto save(ProfessionalCareersDto careersDto) {
        ProfessionalCareersEntity professionalCareersEntity = professionalCareersCrudRepository.save(mapperProfessionalCareers.toEntity(careersDto));
        return mapperProfessionalCareers.toDto(professionalCareersEntity);
    }

    @Override
    public void delete(Long id) {
        professionalCareersCrudRepository.deleteById(id);
    }
}