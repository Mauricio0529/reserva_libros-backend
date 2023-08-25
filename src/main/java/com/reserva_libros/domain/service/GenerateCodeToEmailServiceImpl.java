package com.reserva_libros.domain.service;

import com.reserva_libros.domain.dto.EmailCodeDto;
import com.reserva_libros.domain.useCase.GenerateCodeToEmail;
import com.reserva_libros.infraestructure.exception.CodeToEmailValidationException;

import java.security.SecureRandom;

public class GenerateCodeToEmailServiceImpl implements GenerateCodeToEmail {

    public static String codeEmail;

    @Override
    public boolean randomCodeToEmailValidate(EmailCodeDto code) {

        if(!codeEmail.equals(code.getCode())) {
            throw new CodeToEmailValidationException();
        }
        return true;
    }

    @Override
    public String getRandomCodeToEmailBody() {
        codeEmail = generateRandomCode(4);

        return codeEmail;
    }

    /**
     * Generar codigo numérico aleatorio de una longitud específica
      */
    private String generateRandomCode(int lengthPassword) {

        // Rango numérico (0-9)
        final String chars = "0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder codeEmail = new StringBuilder();

        for (int i = 0; i < lengthPassword; i++) {
            int randomIndex = random.nextInt(chars.length());
            codeEmail.append(chars.charAt(randomIndex));
        }

        return codeEmail.toString();
    }
}
