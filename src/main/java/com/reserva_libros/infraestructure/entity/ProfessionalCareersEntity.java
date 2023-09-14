package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Carrera profesional Entity
 */

@Entity
@Table(name = "professional_careers")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalCareersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    /**
     * Si hay carreras que tengan menos de 10 semestres,
     * se hace esta realcion con carreras
     * para identificar que carreras tienen semestres menor a 10.
     * spicologia tiene 8 semestre
     * Ingenieria de sistemas tiene 10
     */
    //@OneToMany(mappedBy = "professionalCareers", cascade = {CascadeType.ALL})
    //private List<SemesterEntity> semesterEntities;

    @OneToMany(mappedBy = "professionalCareers", cascade = {CascadeType.ALL})
    private List<CareersCycleEntity> careersCycleEntities; /** todos los libros de la reserva */

    @OneToMany(mappedBy = "professionalCareersEntity", cascade = CascadeType.ALL)
    private List<ReservesEntity> reservesEntities;
}