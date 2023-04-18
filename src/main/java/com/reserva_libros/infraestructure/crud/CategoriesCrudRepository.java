package com.reserva_libros.infraestructure.crud;

import com.reserva_libros.infraestructure.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriesCrudRepository extends JpaRepository<CategoriesEntity, Integer> {
        Optional<CategoriesEntity> findByNameCategory(String name);
}