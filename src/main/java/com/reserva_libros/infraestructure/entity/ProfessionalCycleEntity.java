package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Ciclo profesional Entity
 */

@Entity
@Table(name = "professional_cycle")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalCycleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "professionalCycle") // cascade = CascadeType.ALL
    private List<CareersCycleEntity> careersCycleEntities;

    @OneToMany(mappedBy = "professionalCycleEntity", cascade = CascadeType.ALL)
    private List<ReservesEntity> reservesEntities;

    @OneToMany(mappedBy = "professional_cycle", cascade = CascadeType.ALL)
    private List<SemesterEntity> semesterEntities;
}