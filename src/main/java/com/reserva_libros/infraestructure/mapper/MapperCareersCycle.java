package com.reserva_libros.infraestructure.mapper;

import com.reserva_libros.domain.dto.CareersCycleDto;
import com.reserva_libros.infraestructure.entity.CareersCycleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapperCareersCycle {

    @Mapping(source = "cycle_id", target = "id.cycle_id")
    @Mapping(target = "professionalCareers", ignore = true)
    @Mapping(target = "professionalCycle", ignore = true)
    CareersCycleEntity toEntity(CareersCycleDto careersCycleDto);
}