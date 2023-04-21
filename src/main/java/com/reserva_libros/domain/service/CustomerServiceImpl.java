package com.reserva_libros.domain.service;

import com.reserva_libros.domain.dto.CustomerDto;
import com.reserva_libros.domain.repository.CustomerRepository;
import com.reserva_libros.domain.useCase.CustomerService;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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
    public CustomerDto save(CustomerDto customerDto) {
        return customerRepository.save(customerDto);
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto customerDto) {
        if(customerRepository.getCustomerByCardId(customerDto.getCardId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(customerRepository.save(customerDto));
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