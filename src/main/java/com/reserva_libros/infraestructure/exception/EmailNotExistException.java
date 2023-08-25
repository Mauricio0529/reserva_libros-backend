package com.reserva_libros.infraestructure.exception;

/**
 * Mensaje de Excepcion de un email no encontrado
 */
public class EmailNotExistException extends RuntimeException{

    public EmailNotExistException() {
        super("El email no se encuentra registrado.");
    }
}