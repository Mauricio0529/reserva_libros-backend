package com.reserva_libros.application.config;

import com.reserva_libros.domain.repository.*;
import com.reserva_libros.domain.service.*;
import com.reserva_libros.security.JwtAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    public CustomerServiceImpl customerServiceImpl(CustomerRepository customerRepository,
                                                   PasswordEncoder passwordEncoder) {
        return new CustomerServiceImpl(customerRepository, passwordEncoder);
    }

    @Bean
    public BookServiceImpl bookServiceImpl(BookRepository bookRepository) {
        return new BookServiceImpl(bookRepository);
    }

    @Bean
    public AuthService authService(CustomerRepository customerRepository,
                                   JwtAuthenticationProvider jwtAuthenticationProvider,
                                   PasswordEncoder passwordEncoder) {

        return new AuthService(customerRepository, jwtAuthenticationProvider, passwordEncoder);
    }

    @Bean
    public ReservesServiceImpl reservesService(ReservesRepository reservesRepository, BookRepository bookRepository) {
        return new ReservesServiceImpl(reservesRepository, bookRepository);
    }

}