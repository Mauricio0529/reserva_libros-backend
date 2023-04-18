package com.reserva_libros.infraestructure.mapper;

import com.reserva_libros.domain.dto.CategoriesDto;
import com.reserva_libros.infraestructure.entity.CategoriesEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface MapperC {

    // MapperC INSTANCE = Mappers.getMapper(MapperC.class);

    CategoriesDto toCategoriesDto(CategoriesEntity categoriesEntity);

    CategoriesEntity toCategoriesEntity(CategoriesDto categoriesDto);

    List<CategoriesDto> toCategoriesDtoList(List<CategoriesEntity> categoriesEntityList);
}