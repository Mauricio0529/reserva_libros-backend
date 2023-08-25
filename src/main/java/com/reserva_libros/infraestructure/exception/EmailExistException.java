package com.reserva_libros.infraestructure.exception;

public class EmailExistException extends RuntimeException{

    public EmailExistException () {
        super("El email ya se encuentra registrado.");
    }
}