package com.reserva_libros.infraestructure.mapper;

import com.reserva_libros.domain.dto.ProfessionalCareersDto;
import com.reserva_libros.infraestructure.entity.ProfessionalCareersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperProfessionalCareers {

    ProfessionalCareersDto toDto(ProfessionalCareersEntity professionalCareersEntity);

    @Mapping(target = "careersCycleEntities", ignore = true)
    @Mapping(target = "reservesEntities", ignore = true)
    ProfessionalCareersEntity toEntity(ProfessionalCareersDto professionalCareersDto);

    List<ProfessionalCareersDto> toListDto(List<ProfessionalCareersEntity> careersEntityList);
}