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
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservesEntity {
    /**
     * esto seria como el carrito de compras
     * o
     * seria una factura
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_reserva")
    private Integer id;

    @Column(name = "usuarioscedula")
    private Integer customerCardId;

    @Column(name = "total_reservas")
    private Integer totalReserves;

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

}