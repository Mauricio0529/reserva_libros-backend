package com.reserva_libros.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dto de la consulta de una reserva (mostrar la factura o carrito de compras)
 */
public class ReservesResponseDto {
    private Integer id;
    private Integer customerCardId;
    private Integer totalReserves;
    private LocalDateTime dateDelivery;
    private LocalDateTime dateReserves;

    private List<BookReservesResponseDto> booksReserves;

    public ReservesResponseDto() { }

    public ReservesResponseDto(Integer id, Integer customerCardId, Integer totalReserves,
                               LocalDateTime dateDelivery, LocalDateTime dateReserves,
                               List<BookReservesResponseDto> booksReserves) {
        this.id = id;
        this.customerCardId = customerCardId;
        this.totalReserves = totalReserves;
        this.dateDelivery = dateDelivery;
        this.dateReserves = dateReserves;
        this.booksReserves = booksReserves;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerCardId() {
        return customerCardId;
    }

    public void setCustomerCardId(Integer customerCardId) {
        this.customerCardId = customerCardId;
    }

    public Integer getTotalReserves() {
        return totalReserves;
    }

    public void setTotalReserves(Integer totalReserves) {
        this.totalReserves = totalReserves;
    }

    public LocalDateTime getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(LocalDateTime dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public LocalDateTime getDateReserves() {
        return dateReserves;
    }

    public void setDateReserves(LocalDateTime dateReserves) {
        this.dateReserves = dateReserves;
    }

    public List<BookReservesResponseDto> getBooksReserves() {
        return booksReserves;
    }

    public void setBooksReserves(List<BookReservesResponseDto> booksReserves) {
        this.booksReserves = booksReserves;
    }
}
