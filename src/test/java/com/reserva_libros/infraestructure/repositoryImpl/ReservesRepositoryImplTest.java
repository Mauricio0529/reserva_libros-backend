package com.reserva_libros.infraestructure.repositoryImpl;

import com.reserva_libros.domain.dto.CustomerDto;
import com.reserva_libros.domain.repository.ReservesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.context.SecurityContextHolder;

@DataJpaTest
class ReservesRepositoryImplTest {

    @Autowired
    private ReservesRepository reservesRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void saveReserves() {
        CustomerDto c = (CustomerDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(c.getLestName());

    }

}