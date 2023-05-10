package com.reserva_libros.infraestructure.exception;

/**
 * excepcion de usuario no autorizado
 */
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException() {
        super("No tiene los permisos necesarios.");
    }
}
