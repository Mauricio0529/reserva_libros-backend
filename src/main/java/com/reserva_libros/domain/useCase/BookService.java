package com.reserva_libros.domain.useCase;

import com.reserva_libros.domain.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDto> getAll();

    Optional<BookDto> getById(Integer bookId);

    Optional<BookDto> getByTitle(String title);

    /**
     Devuelve lista de libros dada una categoria.
     @param categoryId Id de categoria a buscar.
     @return Lista de lisbros encontrados.
     */
    List<BookDto> getByCategoryId(Integer categoryId);

    /**
     Devuelve lista de libros dada su autor.
     @param authorId Id de autor a buscar.
     @return Lista de libros encontrados.
     */
    List<BookDto> getByAuthorId(Integer authorId);

    /**
     * Devuelve lista de libros apartir de una fecha ingresada.
     * ejemplo: muestreme libros menores o igual desde el año 2000: (2000, 1999, 1998...)
     * @param year Año de publicacion del libro.
     * @return Lista de libros encontrados.
     */
    List<BookDto> getBookByYearLessThan(Integer year);

    BookDto save(BookDto bookDto);

    Optional<BookDto> update(BookDto bookDto);

    boolean delete(Integer bookId);

    boolean deleteByTitle(String title);
}