package com.reserva_libros.infraestructure.repositoryImpl;

import com.reserva_libros.domain.dto.CategoriesDto;
import com.reserva_libros.domain.repository.CategoriesRepository;
import com.reserva_libros.infraestructure.crud.CategoriesCrudRepository;
import com.reserva_libros.infraestructure.entity.CategoriesEntity;
import com.reserva_libros.infraestructure.mapper.MapperC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de categorias
 */

@RequiredArgsConstructor
@Repository
public class CategoriesRepositoryImpl implements CategoriesRepository {

    /**
     * Crud categoria
     * */
    private final CategoriesCrudRepository categoriesCrudRepository;

    /**
     * Mapper de categoria
     */
    private final MapperC mapper;

    @Override
    public List<CategoriesDto> getAll() {
        return mapper.toCategoriesDtoList(categoriesCrudRepository.findAll());
    }

    @Override
    public Optional<CategoriesDto> getCategoryByName(String name) {
        return categoriesCrudRepository.findByNameCategory(name).map(mapper::toCategoriesDto);
    }

    @Override
    public Optional<CategoriesDto> getCategoryById(Integer id) {
        return categoriesCrudRepository.findById(id).map(mapper::toCategoriesDto);
    }

    @Override
    public CategoriesDto save(CategoriesDto categoriesDto) {
        CategoriesEntity categoriesEntity = categoriesCrudRepository.save(mapper.toCategoriesEntity(categoriesDto));
        return mapper.toCategoriesDto(categoriesEntity);
    }

    @Override
    public void delete(Integer id) {
        categoriesCrudRepository.deleteById(id);
    }
}