package com.reserva_libros.infraestructure.repositoryImpl;

import com.reserva_libros.domain.dto.BookReservesResponseDto;
import com.reserva_libros.domain.dto.ReservesCodeResponseDto;
import com.reserva_libros.domain.dto.ReservesRequestDto;
import com.reserva_libros.domain.dto.ReservesResponseDto;
import com.reserva_libros.domain.repository.ReservesRepository;
import com.reserva_libros.infraestructure.crud.ReservesCrudRepository;
import com.reserva_libros.infraestructure.entity.ReservesEntity;
import com.reserva_libros.infraestructure.mapper.MapperReserves;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * carrito de reservas (compra)
 */
@Repository
@RequiredArgsConstructor
public class ReservesRepositoryImpl implements ReservesRepository {

    private final ReservesCrudRepository reservesCrudRepository;

    private final MapperReserves mapperReserves;

    @Override
    public List<ReservesRequestDto> getAll() {
        return mapperReserves.toReservesDtoList(reservesCrudRepository.findAll());
    }

    @Override
    public Optional<ReservesRequestDto> getById(Integer id) {
        return reservesCrudRepository.findById(id).map(mapperReserves::toReservesDto);
    }

    @Override
    public ReservesCodeResponseDto save(ReservesRequestDto reservesRequestDto) {
        ReservesEntity reservesEntity = mapperReserves.toReservesEntity(reservesRequestDto);

        /**
         * estamos pasando el id de reservas a booksReserves.
         * Los libros
         */
        reservesEntity.getBookReservesEntities().forEach(bookReserves -> bookReserves.setReserves(reservesEntity));

        ReservesEntity reservesEntitySave = reservesCrudRepository.save(reservesEntity);

        return new ReservesCodeResponseDto(reservesEntitySave.getId());
    }

    /**
     * ESTE SE HARIA CON EL MAPPER.
     * TOCA MIRAR COMO SE HACE
     */
    public ReservesResponseDto toReservesResponseDtoByEntity(ReservesEntity reservesEntity) {
        ReservesResponseDto reservesResponseDto = new ReservesResponseDto();
        reservesResponseDto.setId(reservesResponseDto.getId());
        reservesResponseDto.setCustomerCardId(reservesEntity.getCustomerCardId());
        reservesResponseDto.setTotalReserves(reservesEntity.getTotalReserves());
        reservesResponseDto.setDateDelivery(reservesEntity.getDateDelivery());
        reservesResponseDto.setDateReserves(reservesEntity.getDateReserves());

        List<BookReservesResponseDto> bookReservesResponseDtoList = new ArrayList<>();

        reservesEntity.getBookReservesEntities().stream().forEach(bookReserves -> {

            bookReservesResponseDtoList.add(new BookReservesResponseDto(bookReserves.getBook().getTitle(), bookReserves.getQuantity()));
        });

        reservesResponseDto.setBooksReserves(bookReservesResponseDtoList);

        return reservesResponseDto;
    }

    @Override
    public void delete(Integer id) {
        reservesCrudRepository.deleteById(id);
    }
}