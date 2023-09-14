package com.reserva_libros.infraestructure.repositoryImpl;

import com.reserva_libros.domain.dto.*;
import com.reserva_libros.domain.repository.ReservesRepository;
import com.reserva_libros.infraestructure.crud.ProfessionalCareersCrudRepository;
import com.reserva_libros.infraestructure.crud.ProfessionalCycleCrudRepository;
import com.reserva_libros.infraestructure.crud.ReservesCrudRepository;
import com.reserva_libros.infraestructure.crud.SemesterCrudRepository;
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

    private final ProfessionalCareersCrudRepository professionalCareersCrudRepository;
    private final ProfessionalCycleCrudRepository professionalCycleCrudRepository;
    private final SemesterCrudRepository semesterCrudRepository;

    private final MapperReserves mapperReserves;

    @Override
    public List<ReservesRequestDto> getAll() {

        List<ReservesEntity> reservesEntities = reservesCrudRepository.findAll();
        List<ReservesRequestDto> reservesRequestDtos = new ArrayList<>();

        reservesEntities.forEach(reservesEntity -> reservesRequestDtos.add(toReservesRequestDtoByEntity(reservesEntity)));
        return reservesRequestDtos;
    }

    @Override
    public Optional<ReservesRequestDto> getById(Integer id) {
        ReservesEntity reservesEntity = reservesCrudRepository.findById(id).get();
        Optional<ReservesRequestDto> reservesRequestDto = Optional.ofNullable(toReservesRequestDtoByEntity(reservesEntity));

        return reservesRequestDto;
    }

    @Override
    public List<ReservesResponseDetailsDto> getByCardIdCustomer(Integer cardId) {
        List<ReservesEntity> reservesEntities = reservesCrudRepository.findAllByCustomerCardId(cardId);
        //List<ReservesRequestDto> reservesRequestDto = new ArrayList<>();
        List<ReservesResponseDetailsDto> reservesRequestDto = new ArrayList<>();
        reservesEntities.stream().forEach(reservesEntity -> reservesRequestDto.add(toReservesResponseDetailsDtoByEntity(reservesEntity)));

        return reservesRequestDto;
    }

    // ReservesCodeResponseDto
    @Override
    public ReservesResponseDetailsDto save(ReservesRequestDto reservesRequestDto) {
        ReservesEntity reservesEntity = mapperReserves.toReservesEntity(reservesRequestDto);

        reservesEntity.getBookReservesEntities().forEach(bookReserves -> bookReserves.setReserves(reservesEntity));
        //reservesEntity.getBookReservesEntities().forEach(bookReserves -> bookReserves.setReserves(reservesEntity));

        ReservesResponseDetailsDto reservesResponseDetailsDto = mapperReserves.toReservesDetailsDto(reservesEntity);

        /** Obtener los valores de carreras profesionales, ciclos y semestres */
        String professionalCareersName = this.professionalCareers(reservesEntity.getProfessionalCareers());
        String professionalCycleName = this.professionalCycle(reservesEntity.getProfessionalCycle());
        int numberSemester = this.numberSemester(reservesEntity.getSemester());

        reservesResponseDetailsDto.setProfessionalCareers(professionalCareersName);
        reservesResponseDetailsDto.setProfessionalCycle(professionalCycleName);
        reservesResponseDetailsDto.setSemester(numberSemester);

        ReservesEntity reservesEntitySave = reservesCrudRepository.save(reservesEntity);

       //return new ReservesCodeResponseDto(reservesEntitySave.getId());
        return reservesResponseDetailsDto;

    }

    private String professionalCareers(Integer professionalCareersId) {
        return professionalCareersCrudRepository.findById(Long.valueOf(professionalCareersId)).get().getName();
    }

    private String professionalCycle(Integer professionalCycleId) {
        return professionalCycleCrudRepository.findById(Long.valueOf(professionalCycleId)).get().getName();
    }

    private Integer numberSemester(Integer semesterId) {
        return semesterCrudRepository.findById(Long.valueOf(semesterId)).get().getNumberSemester();
    }

    /**
     * Mapeando la reserva (request) con la lista de libros reservados
     * @param reservesEntity Entidad a Mapear
     * @return ReservesRequestDto Mapeado a DTO
     */
    public ReservesRequestDto toReservesRequestDtoByEntity(ReservesEntity reservesEntity) {

        List<BookReservesRequestDto> bookReservesRequestDtoList = new ArrayList<>();

        /**
         * recorrer la Lista de libros y la agregamos en una nueva
         */
        reservesEntity.getBookReservesEntities().stream()
                .forEach(bookReserves -> {
            bookReservesRequestDtoList.add(new BookReservesRequestDto(bookReserves.getReserves().getId(),
                    bookReserves.getBook().getBookId(), bookReserves.getQuantity(),
                    bookReserves.getBook().getTitle(), bookReserves.getBook().getImagePath(),
                    bookReserves.getBook().getAuthors().getName()));
        });

        ReservesRequestDto reservesRequestDto = ReservesRequestDto.builder()
                .id(reservesEntity.getId())
                .customerCardId(reservesEntity.getCustomerCardId())
                .totalReserves(reservesEntity.getTotalReserves())
                .professionalCareers(reservesEntity.getProfessionalCareers())
                .professionalCycle(reservesEntity.getProfessionalCycle())
                .semester(reservesEntity.getSemester())
                .dateReserves(reservesEntity.getDateReserves())
                .dateDelivery(reservesEntity.getDateDelivery())
                .bookReservesEntities(bookReservesRequestDtoList)
                .build();

        return reservesRequestDto;
    }

    /**
     * Mapeando la reserva (ResponseDetails) con la lista de libros reservados
     * @param reservesEntity Entidad a Mapear
     * @return ReservesResponseDetailsDto Mapeado a DTO
     */
    public ReservesResponseDetailsDto toReservesResponseDetailsDtoByEntity(ReservesEntity reservesEntity) {

        List<BookReservesRequestDto> bookReservesRequestDtoList = new ArrayList<>();

        /**
         * recorrer la Lista de libros y la agregamos en una nueva
         */
        reservesEntity.getBookReservesEntities().stream()
                .forEach(bookReserves -> {
                    bookReservesRequestDtoList.add(new BookReservesRequestDto(bookReserves.getReserves().getId(),
                            bookReserves.getBook().getBookId(), bookReserves.getQuantity(),
                            bookReserves.getBook().getTitle(), bookReserves.getBook().getImagePath(),
                            bookReserves.getBook().getAuthors().getName()));
                });

        String professionalCareersName = this.professionalCareers(reservesEntity.getProfessionalCareers());
        String professionalCycleName = this.professionalCycle(reservesEntity.getProfessionalCycle());
        int numberSemester = this.numberSemester(reservesEntity.getSemester());

        ReservesResponseDetailsDto reservesResponseDetailsDto = ReservesResponseDetailsDto.builder()
                .id(reservesEntity.getId())
                .customerCardId(reservesEntity.getCustomerCardId())
                .totalReserves(reservesEntity.getTotalReserves())
                .professionalCareers(professionalCareersName)
                .professionalCycle(professionalCycleName)
                .semester(numberSemester)
                .dateReserves(reservesEntity.getDateReserves())
                .dateDelivery(reservesEntity.getDateDelivery())
                .bookReservesEntities(bookReservesRequestDtoList)
                .build();

        return reservesResponseDetailsDto;
    }

    @Override
    public void delete(Integer id) {
        reservesCrudRepository.deleteById(id);
    }
}