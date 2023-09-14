package com.reserva_libros.infraestructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Getter @Setter
public class CareersCyclePK implements Serializable {

    @Serial
    private static final long serialVersionUID = -2145479604343286721L;

    @Column(name = "professional_careers_id")
    private Integer careers_id;

    @Column(name = "professional_cycle_id")
    private Integer cycle_id;
}
