package com.reserva_libros.infraestructure.mapper;

import com.reserva_libros.domain.dto.ProfessionalCycleDto;
import com.reserva_libros.infraestructure.entity.ProfessionalCycleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperProfessionalCycle {

       ProfessionalCycleDto toDto(ProfessionalCycleEntity professionalCycleEntity);

       @Mapping(target = "careersCycleEntities", ignore = true)
       @Mapping(target = "reservesEntities", ignore = true)
       @Mapping(target = "semesterEntities", ignore = true)
       ProfessionalCycleEntity toEntity(ProfessionalCycleDto professionalCycleDto);

       List<ProfessionalCycleDto> toDtoList(List<ProfessionalCycleEntity> cycleEntityList);
}