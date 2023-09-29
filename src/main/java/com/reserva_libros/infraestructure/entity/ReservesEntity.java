package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * entity de reserva
 */

@Entity
@Table(name = "reservas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_reserva")
    private Integer id;

    @Column(name = "usuarioscedula")
    private Integer customerCardId;

    @Column(name = "total_reservas")
    private Integer totalReserves;

    @Column(name = "professional_careers")
    private Integer professionalCareers;

    @Column(name = "professional_cycle")
    private Integer professionalCycle;

    @Column(name = "semester")
    private Integer semester;

    private String status;

    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateDelivery;

    @Column(name = "fecha_reserva")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateReserves;

    @OneToMany(mappedBy = "reserves", cascade = {CascadeType.ALL})
    private List<BookReservesEntity> bookReservesEntities; /** todos los libros de la reserva */

    @ManyToOne()
    @JoinColumn(name = "usuarioscedula", insertable = false, updatable = false)
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "professional_careers", insertable = false, updatable = false) //
    private ProfessionalCareersEntity professionalCareersEntity; //

    @ManyToOne
    @JoinColumn(name = "professional_cycle", insertable = false, updatable = false) //
    private ProfessionalCycleEntity professionalCycleEntity; //

    @ManyToOne
    @JoinColumn(name = "semester", insertable = false, updatable = false) //
    private SemesterEntity semesterEntity; //

}