package com.reserva_libros.domain.service;

import com.reserva_libros.domain.dto.SemesterDto;
import com.reserva_libros.domain.repository.SemesterRepository;
import com.reserva_libros.domain.useCase.SemesterService;

import java.util.List;
import java.util.Optional;

public class SemesterServiceImpl implements SemesterService {

    private final SemesterRepository semesterRepository;

    public SemesterServiceImpl(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    @Override
    public List<SemesterDto> getAll() {
        return semesterRepository.getAll();
    }

    @Override
    public Optional<SemesterDto> getSemesterById(Long id) {
        Optional<SemesterDto> semesterDtoOptional = semesterRepository.getSemesterById(id);
        if(semesterDtoOptional.isEmpty()) {
            return Optional.empty();
        }
        System.out.println(semesterDtoOptional.get().getId() + " " + semesterDtoOptional.get().getProfessionalCycle());
        return semesterDtoOptional;
    }

    @Override
    public List<SemesterDto> getSemesterByProfessionalCycleId(Long id) {
        List<SemesterDto> semesterDtoList = semesterRepository.getSemesterByProfessionalCycleId(id);
        if(semesterDtoList.isEmpty()) {
            return null;
        }
        return semesterDtoList;
    }

    @Override
    public Optional<SemesterDto> getSemesterByNumberSemester(Integer numberSemester) {
        Optional<SemesterDto> semesterDtoOptional = semesterRepository.getSemesterByNumberSemester(numberSemester);
        if(semesterDtoOptional.isEmpty()) {
            return Optional.empty();
        }
        System.out.println(semesterDtoOptional.get().getId() + " " + semesterDtoOptional.get().getProfessionalCycle());
        return semesterDtoOptional;
    }

    @Override
    public SemesterDto save(SemesterDto semesterDto) {
        Optional<SemesterDto> semesterDtoOptional = getSemesterByNumberSemester(semesterDto.getNumberSemester());
        if (semesterDtoOptional.isPresent()) {
            return semesterDto;
        }
        semesterRepository.save(semesterDto);
        return semesterDto;
    }

    @Override
    public Optional<SemesterDto> update(SemesterDto semesterDto) {
        Optional<SemesterDto> semesterDtoOptional = getSemesterByNumberSemester(semesterDto.getNumberSemester());
        if (semesterDtoOptional.isEmpty()) {
            return Optional.empty();
        }
        semesterRepository.save(semesterDto);
        return Optional.of(semesterDto);
    }

    @Override
    public boolean delete(Long id) {
        Optional<SemesterDto> semesterDtoOptional = getSemesterById(id);
        if (semesterDtoOptional.isEmpty()) {
            return false;
        }
        semesterRepository.delete(id);
        return true;
    }
}