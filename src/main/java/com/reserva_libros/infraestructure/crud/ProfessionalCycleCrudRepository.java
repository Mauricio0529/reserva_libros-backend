package com.reserva_libros.infraestructure.crud;

import com.reserva_libros.infraestructure.entity.ProfessionalCycleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfessionalCycleCrudRepository extends JpaRepository<ProfessionalCycleEntity, Long> {

    @Query(value = "SELECT * FROM professional_cycle p WHERE p.name = :name", nativeQuery = true)
    Optional<ProfessionalCycleEntity> findByName(@Param("name") String name);
}