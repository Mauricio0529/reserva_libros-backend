package com.reserva_libros.infraestructure.repositoryImpl;

import com.reserva_libros.domain.dto.BookRequestDto;
import com.reserva_libros.domain.repository.BookRepository;
import com.reserva_libros.infraestructure.crud.BookCrudRepository;
import com.reserva_libros.infraestructure.entity.BookEntity;
import com.reserva_libros.infraestructure.mapper.MapperBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookCrudRepository bookCrudRepository;

    private final MapperBook mapperBook;

    @Override
    public List<BookRequestDto> getAll() {
        return mapperBook.toBookDtoList(bookCrudRepository.findAll());
    }

    @Override
    public Optional<BookRequestDto> getById(Integer bookId) {
        return bookCrudRepository.findById(bookId).map(mapperBook::toBookDto);
    }

    @Override
    public Optional<BookRequestDto> getByTitle(String title) {
        return bookCrudRepository.findByTitle(title).map(mapperBook::toBookDto);
    }

    @Override
    public List<BookRequestDto> getByCategoryId(Integer categoryId) {
        return mapperBook.toBookDtoList(bookCrudRepository.findAllByCategoryId(categoryId));
    }

    @Override
    public List<BookRequestDto> getByAuthorId(Integer authorId) {
        return mapperBook.toBookDtoList(bookCrudRepository.findAllByAuthorId(authorId));
    }

    /**
     * Devuelve lista de libros apartir de una fecha ingresada.
     * ejemplo: muestreme libros menores o igual desde el año 2000: (2000, 1999, 1998...)
     * @param year Año de publicacion del libro.
     * @return Lista de libros encontrados.
     */
    @Override
    public List<BookRequestDto> getBookByYearLessThan(Integer year) {
        return mapperBook.toBookDtoList(bookCrudRepository.findAllByYearOfPublicationLessThanEqualOrderByYearOfPublicationDesc(year));
    }

    @Override
    public BookRequestDto save(BookRequestDto bookDto) {
        if(bookDto.getActive() != 0) {
            bookDto.setActive(1);
        }
        BookEntity bookEntity = bookCrudRepository.save(mapperBook.toBookEntity(bookDto));
        return mapperBook.toBookDto(bookCrudRepository.save(bookEntity));
    }

    @Override
    public void delete(Integer bookId) {
        bookCrudRepository.deleteById(bookId);
    }
}