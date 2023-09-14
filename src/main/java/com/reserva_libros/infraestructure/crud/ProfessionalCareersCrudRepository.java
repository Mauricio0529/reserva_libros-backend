package com.reserva_libros.infraestructure.crud;

import com.reserva_libros.infraestructure.entity.ProfessionalCareersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfessionalCareersCrudRepository extends JpaRepository<ProfessionalCareersEntity, Long> {

    @Query(value = "SELECT * FROM professional_careers p WHERE p.name = :name", nativeQuery = true)
    Optional<ProfessionalCareersEntity> findByName(@Param("name") String name);
}