package com.reserva_libros.infraestructure.exception;

public class CodeToEmailValidationException extends RuntimeException{

    public CodeToEmailValidationException() {
        super("El codigo ingresado es incorrecto");
    }
}