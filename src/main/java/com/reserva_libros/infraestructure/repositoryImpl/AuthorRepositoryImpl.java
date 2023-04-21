package com.reserva_libros.infraestructure.repositoryImpl;

import com.reserva_libros.domain.dto.AuthorDto;
import com.reserva_libros.domain.repository.AuthorRepository;
import com.reserva_libros.infraestructure.crud.AuthorCrudRepository;
import com.reserva_libros.infraestructure.entity.AuthorEntity;
import com.reserva_libros.infraestructure.mapper.MapperAuthor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final AuthorCrudRepository authorCrudRepository;

    private final MapperAuthor mapperAuthor;

    @Override
    public List<AuthorDto> getAll() {
        return mapperAuthor.toAuthorDtoList(authorCrudRepository.findAll());
    }

    @Override
    public Optional<AuthorDto> getAuthorById(Integer id) {
        return authorCrudRepository.findById(id).map(mapperAuthor::toAuthorDto);
    }

    @Override
    public Optional<AuthorDto> getAuthorByName(String name) {
        return authorCrudRepository.findByName(name).map(mapperAuthor::toAuthorDto);
    }

    @Override
    public AuthorDto save(AuthorDto authorDto) {
        AuthorEntity authorEntity = authorCrudRepository.save(mapperAuthor.toAuthorEntity(authorDto));
        return mapperAuthor.toAuthorDto(authorEntity);
    }

    @Override
    public void delete(Integer id) {
        authorCrudRepository.deleteById(id);
    }
}