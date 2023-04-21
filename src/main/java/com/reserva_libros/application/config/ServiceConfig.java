package com.reserva_libros.application.config;

import com.reserva_libros.domain.repository.AuthorRepository;
import com.reserva_libros.domain.repository.CategoriesRepository;
import com.reserva_libros.domain.repository.CustomerRepository;
import com.reserva_libros.domain.service.AuthorServiceImpl;
import com.reserva_libros.domain.service.CategoriesServiceImpl;
import com.reserva_libros.domain.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public CategoriesServiceImpl categoriesServiceImpl(CategoriesRepository categoriesRepository) {
        return new CategoriesServiceImpl(categoriesRepository);
    }

    @Bean
    public AuthorServiceImpl authorServiceImpl(AuthorRepository authorRepository) {
        return new AuthorServiceImpl(authorRepository);
    }

    @Bean
    public CustomerServiceImpl customerServiceImpl(CustomerRepository customerRepository) {
        return new CustomerServiceImpl(customerRepository);
    }

}