package com.reserva_libros.domain.repository;

import com.reserva_libros.domain.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de autor
 */

public interface AuthorRepository {

    /**
     * Devuelve una lista con todos los autores
     * @return List de DTO
     */
    List<AuthorDto> getAll();

    /**
     * Devuelve un autor dada su id
     * @param id Id de autor
     * @return Optional del autor encontrado
     */
    Optional<AuthorDto> getAuthorById(Integer id);

    /**
     * Devuelve un autor dada su Nombre
     * @param name Nombre del autor
     * @return Optional del autor encontrado
     */
    Optional<AuthorDto> getAuthorByName(String name);

    /**
     * Guarda un nuevo autor
     * @param authorDto Autor a guardar
     */
    AuthorDto save(AuthorDto authorDto);

    /**
     * Elimina un autor dado su id
     * @param id Id del autor
     */
    void delete(Integer id);
}