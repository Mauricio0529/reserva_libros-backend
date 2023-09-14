package com.reserva_libros.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SemesterDto {

    private Long id;

    private Integer professionalCycle; // id cicle

    private Integer numberSemester;
}