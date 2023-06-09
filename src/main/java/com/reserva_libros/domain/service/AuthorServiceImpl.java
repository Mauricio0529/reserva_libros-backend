package com.reserva_libros.domain.service;

import com.reserva_libros.domain.dto.AuthorDto;
import com.reserva_libros.domain.repository.AuthorRepository;
import com.reserva_libros.domain.useCase.AuthorService;

import java.util.List;
import java.util.Optional;

public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDto> getAll() {
        return authorRepository.getAll();
    }

    @Override
    public Optional<AuthorDto> getAuthorById(Integer id) {
        return authorRepository.getAuthorById(id);
    }

    @Override
    public Optional<AuthorDto> getAuthorByName(String name) {
        return authorRepository.getAuthorByName(name);
    }

    @Override
    public AuthorDto save(AuthorDto authorDto) {
        Optional<AuthorDto> authorDto1 = getAuthorByName(authorDto.getName());

        if(authorDto1.isPresent()) {
            AuthorDto authorResponse = new AuthorDto();
            authorResponse.setId(authorDto1.get().getId());
            authorResponse.setName(authorDto1.get().getName());
            return authorResponse;
        }

        return authorRepository.save(authorDto);
    }

    @Override
    public Optional<AuthorDto> update(AuthorDto authorDto) {

        if(authorRepository.getAuthorById(authorDto.getId()).isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(authorRepository.save(authorDto));
    }

    @Override
    public boolean delete(Integer id) {
        if(authorRepository.getAuthorById(id).isEmpty()) {
            return false;
        }
        authorRepository.delete(id);
        return true;
    }

    @Override
    public boolean deleteByName(String name) {
        Optional<AuthorDto> authorsDto = authorRepository.getAuthorByName(name);
        if(authorsDto.isEmpty()) {
            return false;
        }
        authorRepository.delete(authorsDto.get().getId());
        return true;
    }
}