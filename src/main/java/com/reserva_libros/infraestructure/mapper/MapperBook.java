package com.reserva_libros.infraestructure.mapper;

import com.reserva_libros.domain.dto.BookDto;
import com.reserva_libros.infraestructure.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperBook {

    BookDto toBookDto(BookEntity bookEntity);

    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "bookReservesEntities", ignore = true)
    BookEntity toBookEntity(BookDto bookDto);

    List<BookDto> toBookDtoList(List<BookEntity> bookEntity);
}