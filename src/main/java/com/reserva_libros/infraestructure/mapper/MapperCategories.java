package com.reserva_libros.infraestructure.mapper;

import com.reserva_libros.domain.dto.CategoriesDto;
import com.reserva_libros.infraestructure.entity.CategoriesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperCategories {

    CategoriesDto toCategoriesDto(CategoriesEntity categoriesEntity);

    @Mapping(target = "bookEntities", ignore = true)
    CategoriesEntity toCategoriesEntity(CategoriesDto categoriesDto);

    List<CategoriesDto> toCategoriesDtoList(List<CategoriesEntity> categoriesEntityList);
}