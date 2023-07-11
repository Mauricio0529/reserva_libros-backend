package com.reserva_libros.domain.useCase;

import com.reserva_libros.domain.dto.BookRequestDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookRequestDto> getAll();

    Optional<BookRequestDto> getById(Integer bookId);

    Optional<BookRequestDto> getByTitle(String title);

    /**
     Devuelve lista de libros dada una categoria.
     @param categoryId Id de categoria a buscar.
     @return Lista de lisbros encontrados.
     */
    List<BookRequestDto> getByCategoryId(Integer categoryId);

    /**
     Devuelve lista de libros dada su autor.
     @param authorId Id de autor a buscar.
     @return Lista de libros encontrados.
     */
    List<BookRequestDto> getByAuthorId(Integer authorId);

    /**
     * Devuelve lista de libros apartir de una fecha ingresada.
     * ejemplo: muestreme libros menores o igual desde el año 2000: (2000, 1999, 1998...)
     * @param year Año de publicacion del libro.
     * @return Lista de libros encontrados.
     */
    List<BookRequestDto> getBookByYearLessThan(Integer year);

    BookRequestDto save(BookRequestDto bookDto);

    Optional<BookRequestDto> update(BookRequestDto bookDto);

    boolean delete(Integer bookId);

    boolean deleteByTitle(String title);
}