package com.reserva_libros.infraestructure.exception;

public class CustomerNotExistException extends RuntimeException {
    public CustomerNotExistException() {
        super("El usuario ingresado no existe.");
    }

}