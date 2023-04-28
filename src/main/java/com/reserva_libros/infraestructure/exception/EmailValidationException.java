package com.reserva_libros.infraestructure.exception;

/**
 * Mensaje de Excepcion de un email requerido
 */
public class EmailValidationException extends RuntimeException {

    public EmailValidationException() {
        super("El email no tiene el formato requerido.");
    }
}