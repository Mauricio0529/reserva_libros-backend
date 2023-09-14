package com.reserva_libros.infraestructure.mapper;

import com.reserva_libros.domain.dto.SemesterDto;
import com.reserva_libros.infraestructure.entity.SemesterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperSemester {

    SemesterDto toDto(SemesterEntity semesterEntity);

    @Mapping(target = "reservesEntities", ignore = true)
    @Mapping(target = "professional_cycle", ignore = true)
    SemesterEntity toEntity(SemesterDto semesterDto);

    List<SemesterDto> toDtoList(List<SemesterEntity> semesterEntityList);
}