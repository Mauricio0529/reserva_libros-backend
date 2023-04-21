package com.reserva_libros.infraestructure.crud;

import com.reserva_libros.infraestructure.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorCrudRepository extends JpaRepository<AuthorEntity, Integer> {
    Optional<AuthorEntity> findByName(String name);
}