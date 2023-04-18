package com.reserva_libros.domain.service;

import com.reserva_libros.domain.dto.CategoriesDto;
import com.reserva_libros.domain.repository.CategoriesRepository;
import com.reserva_libros.domain.useCase.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

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
        return categoriesRepository.getCategoryById(idCategory).isPresent();
    }
}