package com.reserva_libros.infraestructure.repositoryImpl;

import com.reserva_libros.domain.dto.ProfessionalCycleDto;
import com.reserva_libros.domain.repository.ProfessionalCycleRepository;
import com.reserva_libros.infraestructure.crud.ProfessionalCycleCrudRepository;
import com.reserva_libros.infraestructure.entity.ProfessionalCycleEntity;
import com.reserva_libros.infraestructure.mapper.MapperProfessionalCycle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProfessionalCycleRepositoryImpl implements ProfessionalCycleRepository {

    private final ProfessionalCycleCrudRepository professionalCycleCrudRepository;
    private final MapperProfessionalCycle mapperProfessionalCycle;

    @Override
    public List<ProfessionalCycleDto> getAll() {
        return mapperProfessionalCycle.toDtoList(professionalCycleCrudRepository.findAll());
    }

    @Override
    public Optional<ProfessionalCycleDto> getCycleById(Long id) {
        return professionalCycleCrudRepository.findById(id).map(mapperProfessionalCycle::toDto);
    }

    @Override
    public Optional<ProfessionalCycleDto> getCycleByName(String name) {
        return professionalCycleCrudRepository.findByName(name).map(mapperProfessionalCycle::toDto);
    }

    @Override
    public ProfessionalCycleDto save(ProfessionalCycleDto cycleDto) {
        ProfessionalCycleEntity professionalCycleEntity = professionalCycleCrudRepository.save(mapperProfessionalCycle.toEntity(cycleDto));
        return mapperProfessionalCycle.toDto(professionalCycleEntity);
    }

    @Override
    public void delete(Long id) {
        professionalCycleCrudRepository.deleteById(id);
    }
}