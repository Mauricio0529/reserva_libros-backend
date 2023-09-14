package com.reserva_libros.infraestructure.repositoryImpl;

import com.reserva_libros.domain.dto.SemesterDto;
import com.reserva_libros.domain.repository.SemesterRepository;
import com.reserva_libros.infraestructure.crud.SemesterCrudRepository;
import com.reserva_libros.infraestructure.entity.SemesterEntity;
import com.reserva_libros.infraestructure.mapper.MapperSemester;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SemesterRepositoryImpl implements SemesterRepository {

    private final SemesterCrudRepository semesterCrudRepository;
    private final MapperSemester mapperSemester;

    @Override
    public List<SemesterDto> getAll() {
        return mapperSemester.toDtoList(semesterCrudRepository.findAll());
    }

    @Override
    public Optional<SemesterDto> getSemesterById(Long id) {
        return semesterCrudRepository.findById(id).map(mapperSemester::toDto);
    }

    @Override
    public List<SemesterDto> getSemesterByProfessionalCycleId(Long id) {
        return mapperSemester.toDtoList(semesterCrudRepository.findAllByProfessionalCycleId(id));
    }

    @Override
    public Optional<SemesterDto> getSemesterByNumberSemester(Integer numberSemester) {
        return semesterCrudRepository.findByNumberSemester(numberSemester).map(mapperSemester::toDto);
    }

    @Override
    public SemesterDto save(SemesterDto semesterDto) {
        SemesterEntity semesterEntity = semesterCrudRepository.save(mapperSemester.toEntity(semesterDto));
        return mapperSemester.toDto(semesterEntity);
    }

    @Override
    public void delete(Long id) {
        semesterCrudRepository.deleteById(id);
    }
}