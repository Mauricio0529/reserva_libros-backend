package com.reserva_libros.domain.service;

import com.reserva_libros.domain.constants.StatusReserveConstants;
import com.reserva_libros.domain.dto.BookRequestDto;
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

    @Override
    public List<ReservesResponseDetailsDto> getByStatusReserve(String statusReserve) {
        List<ReservesResponseDetailsDto> reservesDto = reservesRepository.getByStatus(statusReserve);
        if(!reservesDto.isEmpty()) {
            return reservesDto;
        }
        return null;
    }

    // ReservesCodeResponseDto
    @Override
    public ReservesResponseDetailsDto save(ReservesRequestDto reservesRequestDto) {
        String newState = StatusReserveConstants.IN_PROGRESS;
        ReservesResponseDetailsDto reservesResponseDetailsDto = reservesRepository.save(reservesRequestDto, newState); // nuevo
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

    /**
     * ACTUALIZAR UNA RESERVA
     * @param reservesRequestDto Objecto reserva a modificar
     * @return
     */
    // ReservesCodeResponseDto
    @Override
    public Optional<ReservesResponseDetailsDto> update(ReservesRequestDto reservesRequestDto) {
        if(getById(reservesRequestDto.getId()).isEmpty()) {
            return Optional.empty();
        }
        String stateActually = reservesRequestDto.getStatus();
        ReservesResponseDetailsDto responseDetailsDto = reservesRepository.save(reservesRequestDto, stateActually);
        return Optional.of(responseDetailsDto);
    }

    /**
     * ACTUALIZAR ESTADO DE LA RESERVA
     * @param id Id de la reserva(Numero de factura)
     * @return
     */
    @Override
    public Optional<ReservesRequestDto> updateStatus(Integer id) {
        Optional<ReservesRequestDto> optionalReservesRequestDto = getById(id);
        if(optionalReservesRequestDto.isEmpty()) {
            return Optional.empty();
        }
        if(optionalReservesRequestDto.get().getStatus().equals(StatusReserveConstants.FINALIZED)) {
            throw new RuntimeException("Estado Ya Finalizado");
        }
        ReservesRequestDto reservesRequestDto = optionalReservesRequestDto.get();
        String newStatus = determineNewStatus(reservesRequestDto.getStatus());
        reservesRepository.save(reservesRequestDto, newStatus);

        return Optional.of(reservesRequestDto);
    }

    private String determineNewStatus(String existingStatus) {
        if (existingStatus.equals(StatusReserveConstants.IN_PROGRESS)) {
            return StatusReserveConstants.ACCEPTED;
        } else if (existingStatus.equals(StatusReserveConstants.ACCEPTED)) {
            return StatusReserveConstants.FINALIZED;
        } else {
            return StatusReserveConstants.IN_PROGRESS;
        }
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