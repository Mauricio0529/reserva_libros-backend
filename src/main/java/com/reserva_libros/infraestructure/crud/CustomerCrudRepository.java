package com.reserva_libros.infraestructure.crud;

import com.reserva_libros.infraestructure.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerCrudRepository extends JpaRepository<CustomerEntity, Integer> {

    Optional<CustomerEntity> findByUsername(String username);
    Optional<CustomerEntity> findByEmail(String email);
}