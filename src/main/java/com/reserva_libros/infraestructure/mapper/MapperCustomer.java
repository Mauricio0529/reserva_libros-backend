package com.reserva_libros.infraestructure.mapper;

import com.reserva_libros.domain.dto.CustomerDto;
import com.reserva_libros.infraestructure.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperCustomer {

    CustomerDto toCustomerDto(CustomerEntity customerEntity);

    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    List<CustomerDto> toCustomerDtoList(List<CustomerEntity> customerEntities);

}