package com.reserva_libros.domain.service;

import com.reserva_libros.domain.dto.BookRequestDto;
import com.reserva_libros.domain.dto.BookResponseDto;
import com.reserva_libros.domain.repository.BookRepository;
import com.reserva_libros.domain.useCase.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<BookResponseDto> getAll() {
        System.out.println("lista de AUTORIDADES");
        var listaRoles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        System.out.println(listaRoles);

        return bookRepository.getAll();
    }

    @Override
    public Optional<BookRequestDto> getById(Integer bookId) {
        return bookRepository.getById(bookId);
    }

    @Override
    public Optional<BookRequestDto> getByTitle(String title) {
        return bookRepository.getByTitle(title);
    }

    @Override
    public List<BookRequestDto> getByCategoryId(Integer categoryId) {
        return bookRepository.getByCategoryId(categoryId);
    }

    @Override
    public List<BookRequestDto> getByAuthorId(Integer authorId) {
        return bookRepository.getByAuthorId(authorId);
    }

    @Override
    public List<BookRequestDto> getBookByYearLessThan(Integer year) {
        return bookRepository.getBookByYearLessThan(year);
    }

    @Override
    public BookRequestDto save(BookRequestDto bookDto) {
        return bookRepository.save(bookDto);
    }

    @Override
    public Optional<BookRequestDto> update(BookRequestDto bookDto) {
        if(bookRepository.getById(bookDto.getBookId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(bookRepository.save(bookDto));
    }

    @Override
    public boolean delete(Integer bookId) {
        if(bookRepository.getById(bookId).isEmpty()) {
            return false;
        }
        bookRepository.delete(bookId);
        return true;
    }

    @Override
    public boolean deleteByTitle(String title) {
        Optional<BookRequestDto> bookDto = bookRepository.getByTitle(title);

        if(bookDto.isEmpty()) {
            return false;
        }
        bookRepository.delete(bookDto.get().getBookId());
        return true;
    }
}