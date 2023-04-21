package com.reserva_libros.domain.useCase;

import com.reserva_libros.domain.dto.CategoriesDto;

import java.util.List;
import java.util.Optional;

public interface CategoriesService {

    /**
     * Devuelve una lista con todas las categorias
     */
    List<CategoriesDto> getAll();

    /**
     * Devuelve una categoria dada su nombre
     * @param name Nombre de la categoria
     * @return Optional de la categoria encontrada
     */
    Optional<CategoriesDto> getCategory(String name);

    /**
     * Guarda una nueva categoria
     * @param categoriesDto Categoria a guardar
     */
    CategoriesDto save(CategoriesDto categoriesDto);

    /**
     * Actualiza una categoria
     * @param categoriesDto Categoria a actualizar
     * @return Optional, al buscar por id o nombre por jpa devuelve un Optional
     */
    Optional<CategoriesDto> update(CategoriesDto categoriesDto);

    /**
     * Elimina una categoria dada su id
     * @param idCategory Id de la categoria a eliminar
     * @return true si se eliminó, false de lo contrario
     */
    boolean delete(Integer idCategory);

    boolean deleteByNameCategory(String name);
}
