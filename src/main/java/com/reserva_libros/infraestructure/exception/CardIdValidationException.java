package com.reserva_libros.infraestructure.exception;

public class CardIdValidationException extends RuntimeException{

    public  CardIdValidationException() {
        super("La cedula ingresada ya existe");
    }

}
