package com.reserva_libros.application.config;

import com.reserva_libros.domain.repository.CategoriesRepository;
import com.reserva_libros.domain.service.CategoriesServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public CategoriesServiceImpl categoriesServiceImpl(CategoriesRepository categoriesRepository) {
        return new CategoriesServiceImpl(categoriesRepository);
    }

}