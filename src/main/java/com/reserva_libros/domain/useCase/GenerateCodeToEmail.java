package com.reserva_libros.domain.useCase;

import com.reserva_libros.domain.dto.EmailCodeDto;

public interface GenerateCodeToEmail {

    boolean randomCodeToEmailValidate(EmailCodeDto code);

    String getRandomCodeToEmailBody();
}