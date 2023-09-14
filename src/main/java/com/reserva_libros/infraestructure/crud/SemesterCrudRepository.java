package com.reserva_libros.infraestructure.crud;

import com.reserva_libros.infraestructure.entity.SemesterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SemesterCrudRepository extends JpaRepository<SemesterEntity, Long> {

    @Query(value = "SELECT * FROM semester s WHERE s.professional_cycle = :professionalCycle", nativeQuery = true)
    List<SemesterEntity> findAllByProfessionalCycleId(@Param("professionalCycle") Long professionalCycle); //findByProfessionalCycleId

    @Query(value = "SELECT * FROM semester s WHERE s.number_semester = :numberSemester", nativeQuery = true)
    Optional<SemesterEntity> findByNumberSemester(@Param("numberSemester") Integer numberSemester);
}