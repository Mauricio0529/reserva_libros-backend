package com.reserva_libros.infraestructure.mapper;

import com.reserva_libros.domain.dto.BookReservesRequestDto;
import com.reserva_libros.infraestructure.entity.BookReservesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapperBookReserves {

    @Mapping(source = "bookId", target = "id.bookId")
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "reserves", ignore = true)
    // @Mapping(target = "id.purchaseNumberBill", ignore = true)
    BookReservesEntity toBookReservesEntity(BookReservesRequestDto reservesRequestDto);
}
