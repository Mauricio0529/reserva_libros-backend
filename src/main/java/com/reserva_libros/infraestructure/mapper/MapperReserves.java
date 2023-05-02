package com.reserva_libros.infraestructure.mapper;

import com.reserva_libros.domain.dto.ReservesRequestDto;
import com.reserva_libros.infraestructure.entity.ReservesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperReserves {

    ReservesRequestDto toReservesDto(ReservesEntity reservesEntity);

    @Mapping(target = "customer", ignore = true)
    ReservesEntity toReservesEntity(ReservesRequestDto reservesRequestDto);

    List<ReservesRequestDto> toReservesDtoList(List<ReservesEntity> reservesEntities);

}