package com.reserva_libros.infraestructure.repositoryImpl;

import com.reserva_libros.domain.dto.*;
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

        List<ReservesEntity> reservesEntities = reservesCrudRepository.findAll();
        List<ReservesRequestDto> reservesRequestDtos = new ArrayList<>();
/*
        reservesEntities.forEach(reservesEntity -> reservesRequestDtos.add(toReservesResponseDtoByEntity(reservesEntity)));
*/
        reservesEntities.forEach(reservesEntity -> reservesRequestDtos.add(toReservesRequestDtoByEntity(reservesEntity)));
        return reservesRequestDtos;
    }

    @Override
    public Optional<ReservesRequestDto> getById(Integer id) {
        ReservesEntity reservesEntity = reservesCrudRepository.findById(id).get();
        Optional<ReservesRequestDto> reservesRequestDto = Optional.ofNullable(toReservesRequestDtoByEntity(reservesEntity));

        return reservesRequestDto;

        //return reservesCrudRepository.findById(id).map(mapperReserves::toReservesDto);
    }

    @Override
    public List<ReservesRequestDto> getByCardIdCustomer(Integer cardId) {
        List<ReservesEntity> reservesEntities = reservesCrudRepository.findAllByCustomerCardId(cardId);
        List<ReservesRequestDto> reservesRequestDto = new ArrayList<>();

        reservesEntities.stream().forEach(reservesEntity -> {
            reservesRequestDto.add(toReservesRequestDtoByEntity(reservesEntity));
        });

        return reservesRequestDto;
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

        reservesResponseDto.setId(reservesEntity.getId());
        reservesResponseDto.setCustomerCardId(reservesEntity.getCustomerCardId());
        reservesResponseDto.setTotalReserves(reservesEntity.getTotalReserves());
        reservesResponseDto.setDateDelivery(reservesEntity.getDateDelivery());
        reservesResponseDto.setDateReserves(reservesEntity.getDateReserves());

        List<BookReservesResponseDto> bookReservesResponseDtoList = new ArrayList<>();

        //List<BookReservesRequestDto> bookReservesResponseDtoList = new ArrayList<>();

        reservesEntity.getBookReservesEntities().stream().forEach(bookReserves -> {

            bookReservesResponseDtoList.add(new BookReservesResponseDto(bookReserves.getBook().getTitle(), bookReserves.getQuantity()));

            //bookReservesResponseDtoList.add(new BookReservesRequestDto(bookReserves.getReserves().getId(),
              //                              bookReserves.getBook().getBookId(), bookReserves.getQuantity()));
        });

        reservesResponseDto.setBooksReserves(bookReservesResponseDtoList);
        //reservesResponseDto.setBookReservesEntities(bookReservesResponseDtoList);

        return reservesResponseDto;
    }


    public ReservesRequestDto toReservesRequestDtoByEntity(ReservesEntity reservesEntity) {

        List<BookReservesRequestDto> bookReservesRequestDtoList = new ArrayList<>();

        /**
         * recorrer la Lista de libros y la agregamos en una nueva
         */
        reservesEntity.getBookReservesEntities().stream().forEach(bookReserves -> {
            bookReservesRequestDtoList.add(new BookReservesRequestDto(bookReserves.getReserves().getId(),
                    bookReserves.getBook().getBookId(), bookReserves.getQuantity(), bookReserves.getBook().getTitle(), bookReserves.getBook().getImagePath()));
        });

        ReservesRequestDto reservesRequestDto = ReservesRequestDto.builder()
                .id(reservesEntity.getId())
                .customerCardId(reservesEntity.getCustomerCardId())
                .totalReserves(reservesEntity.getTotalReserves())
                .dateReserves(reservesEntity.getDateReserves())
                .dateDelivery(reservesEntity.getDateDelivery())
                .bookReservesEntities(bookReservesRequestDtoList)
                .build();


        //reservesRequestDto.setBookReservesEntities(bookReservesRequestDtoList);

        return reservesRequestDto;
    }

    @Override
    public void delete(Integer id) {
        reservesCrudRepository.deleteById(id);
    }
}