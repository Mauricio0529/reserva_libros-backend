package com.reserva_libros.infraestructure.crud;

import com.reserva_libros.infraestructure.entity.ReservesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservesCrudRepository extends JpaRepository<ReservesEntity, Integer> {

}