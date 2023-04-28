package com.reserva_libros.domain.repository;

import com.reserva_libros.domain.dto.CategoriesDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface del repositorio de categoria
 */
public interface CategoriesRepository {

    /**
     * Devuelve una lista con todas las categorias
     */
    List<CategoriesDto> getAll();

    /**
     * Devuelve una categoria dada su nombre
     * @param name Nombre de la categoria
     * @return Optional de la categoria encontrada
     */
    Optional<CategoriesDto> getCategoryByName(String name);

    /**
     * Devuelve una categoria dada su id
     * @param id Id de la categoria
     * @return Optional de la categoria encontrada
     */
    Optional<CategoriesDto> getCategoryById(Integer id);

    /**
     * Guarda una nueva categoria
     * @param categoriesDto Categoria a guardar
     */
    CategoriesDto save(CategoriesDto categoriesDto);

    /**
     * Elimina una categoria dada su id
     * @param id Id de la categoria a eliminar
     */
    void delete(Integer id);
}