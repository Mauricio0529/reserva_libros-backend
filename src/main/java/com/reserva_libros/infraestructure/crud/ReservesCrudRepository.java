package com.reserva_libros.infraestructure.crud;

import com.reserva_libros.infraestructure.entity.ReservesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservesCrudRepository extends JpaRepository<ReservesEntity, Integer> {

    List<ReservesEntity> findAllByCustomerCardId(Integer cardId);
    List<ReservesEntity> findAllByStatus(String statusReserve);

}