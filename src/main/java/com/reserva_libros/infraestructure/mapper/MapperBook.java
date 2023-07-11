package com.reserva_libros.infraestructure.mapper;

import com.reserva_libros.domain.dto.BookRequestDto;
import com.reserva_libros.infraestructure.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperBook {

    BookRequestDto toBookDto(BookEntity bookEntity);

    //List<BookResponseDto> toBookResponseDto(List<BookEntity> bookEntity);  // prueba

    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "bookReservesEntities", ignore = true)
    BookEntity toBookEntity(BookRequestDto bookDto);

    List<BookRequestDto> toBookDtoList(List<BookEntity> bookEntity);
}