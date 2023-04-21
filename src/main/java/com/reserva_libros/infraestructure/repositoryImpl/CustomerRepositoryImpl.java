package com.reserva_libros.infraestructure.repositoryImpl;

import com.reserva_libros.domain.dto.CustomerDto;
import com.reserva_libros.domain.repository.CustomerRepository;
import com.reserva_libros.infraestructure.crud.CustomerCrudRepository;
import com.reserva_libros.infraestructure.entity.CustomerEntity;
import com.reserva_libros.infraestructure.mapper.MapperCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerCrudRepository customerCrudRepository;

    private final MapperCustomer mapperCustomer;

    @Override
    public List<CustomerDto> getAll() {
        return mapperCustomer.toCustomerDtoList(customerCrudRepository.findAll());
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(Integer cardId) {
        return customerCrudRepository.findById(cardId).map(mapperCustomer::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByUserName(String username) {
        return customerCrudRepository.findByUsername(username).map(mapperCustomer::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return  customerCrudRepository.findByEmail(email).map(mapperCustomer::toCustomerDto);
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        CustomerEntity customerEntity = customerCrudRepository.save(mapperCustomer.toCustomerEntity(customerDto));
        return mapperCustomer.toCustomerDto(customerEntity);
    }

    @Override
    public void delete(Integer cardId) {
        customerCrudRepository.deleteById(cardId);
    }
}