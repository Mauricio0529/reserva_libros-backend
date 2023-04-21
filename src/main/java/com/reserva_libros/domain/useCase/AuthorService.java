package com.reserva_libros.domain.useCase;

import com.reserva_libros.domain.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
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
     * Actualiza / Modifica un autor
     * @param authorDto Autor a modificar
     */
    Optional<AuthorDto> update(AuthorDto authorDto);

    /**
     * Elimina un autor dado su id
     * @param id Id del autor
     */
    boolean delete(Integer id);

    /**
     * Elimina un autor dado su Nombre
     * @param name Nombre del autor
     * @return True si el autor se elimino
     */
    boolean deleteByName(String name);
}