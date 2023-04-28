package com.reserva_libros.infraestructure.crud;

import com.reserva_libros.infraestructure.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookCrudRepository extends JpaRepository<BookEntity, Integer> {

    Optional<BookEntity> findByTitle(String title);

    List<BookEntity> findAllByCategoryId(Integer categoryId);

    List<BookEntity> findAllByAuthorId(Integer authorId);

    /**
     * SELECT * FROM libros WHERE anio_publicacion < 2000 ORDER BY anio_publicacion DESC;
     * @return Devuelve lista de libros menor al año que se indique de forma ordenada de Mayor a menor
     */
    List<BookEntity> findAllByYearOfPublicationLessThanEqualOrderByYearOfPublicationDesc(Integer bookYear);

}