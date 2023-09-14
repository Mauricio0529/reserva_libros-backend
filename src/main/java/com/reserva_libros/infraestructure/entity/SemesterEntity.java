package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Semestre Entity
 */

@Entity
@Table(name = "semester")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SemesterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "professional_cycle")
    private Integer professionalCycle; // id del ciclo

    //@Column(name = "professional_careers")
    //private Integer professional_careers;

    @Column(name = "number_semester")
    private Integer numberSemester;

    @OneToMany(mappedBy = "semesterEntity", cascade = CascadeType.ALL)
    private List<ReservesEntity> reservesEntities;

    @ManyToOne
    @JoinColumn(name = "professional_cycle", insertable = false, updatable = false) //
    private ProfessionalCycleEntity professional_cycle;

    /**
     * Si hay carreras que tengan menos de 10 semestres,
     * se hace esta realcion con carreras
     * para identificar que carreras tienen semestres menor a 10.
     * spicologia tiene 8 semestre
     * Ingenieria de sistemas tiene 10
     */
    //@ManyToOne
    //@JoinColumn(name = "professional_careers", insertable = false, updatable = false) //
    //private ProfessionalCareersEntity professionalCareers;
}