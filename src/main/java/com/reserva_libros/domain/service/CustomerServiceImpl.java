package com.reserva_libros.domain.service;

import com.reserva_libros.domain.dto.CustomerDto;
import com.reserva_libros.domain.dto.ResponseCustomerDto;
import com.reserva_libros.domain.repository.CustomerRepository;
import com.reserva_libros.domain.useCase.CustomerService;
import com.reserva_libros.infraestructure.exception.CardIdValidationException;
import com.reserva_libros.infraestructure.exception.EmailValidationException;
import com.reserva_libros.security.Roles;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<CustomerDto> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(Integer cardId) {
        return customerRepository.getCustomerByCardId(cardId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByUserName(String username) {
        return customerRepository.getCustomerByUserName(username);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return customerRepository.getCustomerByEmail(email);
    }

    @Override
    public ResponseCustomerDto save(CustomerDto customerDto) {

        /**
         * Validar el email, esto retorna boolean,
         * true si cumple la condicion y hace el match.
         */
        if(!customerDto.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new EmailValidationException();
        }

        if(getCustomerByCardId(customerDto.getCardId()).isPresent() || getCustomerByEmail(customerDto.getEmail()).isPresent()) {
            throw new CardIdValidationException();
        }

        /** GENERAMOS LA CONTRASEÑA */
        String passwordGenerated = generateRandomPassword(8);
        customerDto.setPassword(passwordEncoder.encode(passwordGenerated));
        customerDto.setActive(1);
        customerDto.setRol(Roles.CUSTOMER);

        customerRepository.save(customerDto);

        return new ResponseCustomerDto(passwordGenerated);
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto customerDto) {
        if(customerRepository.getCustomerByCardId(customerDto.getCardId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(customerRepository.save(customerDto));
    }

    // Método para generar una contraseña alfanumérica aleatoria de una longitud específica
    private String generateRandomPassword(int lengthPassword) {

        // Rango ASCII – alfanumérico (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // cada iteración del bucle elige aleatoriamente un carácter del dado
        // rango ASCII y lo agrega a la instancia `StringBuilder`

        for (int i = 0; i < lengthPassword; i++) {
            int randomIndex = random.nextInt(chars.length());
            password.append(chars.charAt(randomIndex));
        }

        return password.toString();
    }

    @Override
    public boolean deleteById(Integer cardId) {
        if (customerRepository.getCustomerByCardId(cardId).isEmpty()) {
            return false;
        }
        customerRepository.delete(cardId);
        return true;
    }

    @Override
    public boolean deleteByUserName(String username) {
        Optional<CustomerDto> customerDto = customerRepository.getCustomerByUserName(username);
        if (customerDto.isEmpty()) {
            return false;
        }
        customerRepository.delete(customerDto.get().getCardId());
        return true;
    }

    @Override
    public boolean deleteByEmail(String email) {
        Optional<CustomerDto> customerDto = customerRepository.getCustomerByEmail(email);
        if (customerDto.isEmpty()) {
            return false;
        }
        customerRepository.delete(customerDto.get().getCardId());
        return true;
    }
}