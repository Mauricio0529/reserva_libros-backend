package com.reserva_libros.domain.service;

import com.reserva_libros.domain.dto.CategoriesDto;
import com.reserva_libros.domain.repository.CategoriesRepository;
import com.reserva_libros.domain.useCase.CategoriesService;

import java.util.List;
import java.util.Optional;

public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<CategoriesDto> getAll() {
        return categoriesRepository.getAll();
    }

    @Override
    public Optional<CategoriesDto> getCategory(String name) {
        return categoriesRepository.getCategoryByName(name);
    }

    @Override
    public CategoriesDto save(CategoriesDto categoriesDto) {
        return categoriesRepository.save(categoriesDto);
    }

    /**
     * Se usa Optional para no retornar un null.
     */
    @Override
    public Optional<CategoriesDto> update(CategoriesDto categoriesDto) {
        /** validar si la categoria viene vacia, validar si hay una categoria */
        if (categoriesRepository.getCategoryById(categoriesDto.getId()).isEmpty()) {
            return Optional.empty();
        }
        return  Optional.of(categoriesRepository.save(categoriesDto));
    }

    @Override
    public boolean delete(Integer idCategory) {
        /** validar si la categoria viene vacia, validar si hay una categoria */
        if (categoriesRepository.getCategoryById(idCategory).isEmpty()) {
            return false;
        }
        categoriesRepository.delete(idCategory);
        return true;
    }

    @Override
    public boolean deleteByNameCategory(String name) {
        Optional<CategoriesDto> categoriesDto = categoriesRepository.getCategoryByName(name);

        if(categoriesDto.isEmpty()) {
            return false;
        }
        categoriesRepository.delete(categoriesDto.get().getId());
        return true;
    }
}