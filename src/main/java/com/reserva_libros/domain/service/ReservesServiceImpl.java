package com.reserva_libros.domain.service;

import com.reserva_libros.domain.dto.BookRequestDto;
import com.reserva_libros.domain.dto.ReservesCodeResponseDto;
import com.reserva_libros.domain.dto.ReservesRequestDto;
import com.reserva_libros.domain.dto.ReservesResponseDetailsDto;
import com.reserva_libros.domain.repository.BookRepository;
import com.reserva_libros.domain.repository.ReservesRepository;
import com.reserva_libros.domain.useCase.ReservesUseCase;

import java.util.List;
import java.util.Optional;

public class ReservesServiceImpl implements ReservesUseCase {

    private final ReservesRepository reservesRepository;
    private final BookRepository bookRepository;

    public ReservesServiceImpl(ReservesRepository reservesRepository, BookRepository bookRepository) {
        this.reservesRepository = reservesRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<ReservesRequestDto> getAll() {
        return reservesRepository.getAll();
    }

    @Override
    public Optional<ReservesRequestDto> getById(Integer idReserves) {
        Optional<ReservesRequestDto> reservesRequestDto = reservesRepository.getById(idReserves);
        if(reservesRequestDto.isPresent()) {
            return reservesRequestDto;
        }
        return Optional.empty();
    }

    // ReservesRequestDto
    @Override
    public List<ReservesResponseDetailsDto> getByCustomerCardId(Integer cardId) {
        //List<ReservesRequestDto> reservesDto = reservesRepository.getByCardIdCustomer(cardId);
        List<ReservesResponseDetailsDto> reservesDto = reservesRepository.getByCardIdCustomer(cardId);
        if(!reservesDto.isEmpty()) {
            return reservesDto;
        }
        return null;
    }

    // ReservesCodeResponseDto
    @Override
    public ReservesResponseDetailsDto save(ReservesRequestDto reservesRequestDto) {
        ReservesResponseDetailsDto reservesResponseDetailsDto = reservesRepository.save(reservesRequestDto);
        //ReservesCodeResponseDto numberReserves = reservesRepository.save(reservesRequestDto);

        /**
         * Actualizar el estado del libro a reservado ( con el numero 0 )
         */
        reservesRequestDto.getBookReservesEntities().forEach(bookReserve -> {

            BookRequestDto bookRequest = bookRepository.getById(bookReserve.getBookId()).get();

            // estado reservado
            if(bookRequest.getActive() != 0 ) {
                bookRequest.setActive(bookRequest.getActive()-1);
            }

            System.out.println("\nTitulo Libro: " + bookRequest.getTitle() + ", Estado Libro: " + bookRequest.getActive());

            System.out.println(
                    "\nTitulo Libro: " + bookRequest.getTitle() +
                    "\nID Autor: " + bookRequest.getAuthorId() +
                    " \nId Libro:" + bookRequest.getBookId() +
                    "\nID Categoria " + bookRequest.getCategoryId() );

            // se guarda el libro con el nuevo estado (Estado reservado)
            bookRepository.save(bookRequest);
        });

        //return numberReserves;
        return reservesResponseDetailsDto;
    }

    // ReservesCodeResponseDto
    @Override
    public Optional<ReservesResponseDetailsDto> update(ReservesRequestDto reservesRequestDto) {
        if(reservesRepository.getById(reservesRequestDto.getId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(reservesRepository.save(reservesRequestDto));
    }

    @Override
    public boolean delete(Integer idReserves) {
        if(reservesRepository.getById(idReserves).isEmpty()) {
            return false;
        }

        reservesRepository.delete(idReserves);
        return true;
    }
}