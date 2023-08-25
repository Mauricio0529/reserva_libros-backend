package com.reserva_libros.domain.service;

import com.reserva_libros.domain.dto.CustomerDto;
import com.reserva_libros.domain.dto.EmailBodyDto;
import com.reserva_libros.domain.dto.ResponseCustomerDto;
import com.reserva_libros.domain.repository.CustomerRepository;
import com.reserva_libros.domain.useCase.EmailPort;
import com.reserva_libros.infraestructure.exception.EmailNotExistException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Servicio para enviar mensaje al correo electronico
 */
public class EmailServiceImpl implements EmailPort {

    private final JavaMailSender sender;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public EmailServiceImpl(JavaMailSender sender, CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.sender = sender;
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Agregar datos al contenido del email a enviar
     * Envia el mensaje de codigo al email ingresado
     * @param emailRequest Email de usuario a enviar
     * @return true Si se envio correctamente
     */

    @Override
    public CustomerDto sendEmail(String emailRequest) {

        EmailBodyDto emailBody = new EmailBodyDto();

        String urlPageUpdatePassword = "http://localhost:4200/autenticacion/update-password ";

        CustomerDto customerDto = getEmailToCustomer(emailRequest);

        emailBody.setEmail(customerDto.getEmail());

        emailBody.setContent("Restablezca su contraseña dando click al siguiente enlace: " + urlPageUpdatePassword); // el contenido del mensaje

        emailBody.setSubject("Recuperación de cuenta"); // el asunto

        boolean sendEmail = sendEmailTool(emailBody.getContent(), emailBody.getEmail(), emailBody.getSubject());

        if (!sendEmail) {
            return null;
        }

        return customerDto;
    }

    /**
     * Envia el mensaje de codigo al email ingresado
     * @param textMessage Contenido del mensaje de email a enviar
     * @param email Email de usuario a enviar
     * @param subject Asundo o Encabezado de email
     * @return true Si se envio correctamente
     */
    private boolean sendEmailTool(String textMessage, String email, String subject) {
        boolean send = false;

        // Mime es para enviar
        MimeMessage message = sender.createMimeMessage();

        // Para llenar o agregar contenido al mensaje de correo
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(email);
            helper.setText(textMessage, true);
            helper.setSubject(subject);
            sender.send(message);
            send = true;

            System.out.println("Mail enviado! ");
        } catch (MessagingException e) {
            System.out.println("Hubo un error al enviar el mail: {} " + e);
        }
        return send;
    }

    /**
     * Obtener un usuario dado su correo
     * @param email Email de usuario a buscar
     * @return Email de usuario encontrado
     */
    public CustomerDto getEmailToCustomer(String email) {

        CustomerDto customerDto = customerRepository.getCustomerByEmail(email).get();
        if(customerDto == null) {
            throw new EmailNotExistException();
        }

        return customerDto;
    }

    /**
     * Actualizar contraseña de un usuario
     * @param newCustomerDto Usuario a modificar
     * @return La nueva contraseña
     */
    @Override
    public ResponseCustomerDto customerPasswordUpdate(CustomerDto newCustomerDto) {
        String newPasswordCustomer = newCustomerDto.getPassword();
        newCustomerDto.setPassword(passwordEncoder.encode(newPasswordCustomer));
        customerRepository.save(newCustomerDto);
        return new ResponseCustomerDto(newPasswordCustomer);
    }
}