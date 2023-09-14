package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "careers_cycles")
@Getter @Setter
public class CareersCycleEntity {

    @EmbeddedId
    private CareersCyclePK id;

    @ManyToOne()
    @MapsId(value = "careers_id")
    @JoinColumn(name = "professional_careers_id", insertable = false, updatable = false)
    private ProfessionalCareersEntity professionalCareers;

    @ManyToOne()
    @JoinColumn(name = "professional_cycle_id", insertable = false, updatable = false)
    private ProfessionalCycleEntity professionalCycle;
}