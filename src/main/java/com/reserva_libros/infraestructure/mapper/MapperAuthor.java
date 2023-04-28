package com.reserva_libros.infraestructure.mapper;

import com.reserva_libros.domain.dto.AuthorDto;
import com.reserva_libros.infraestructure.entity.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperAuthor {

    /**
     * Contierte una Entidad a DTO de autor
     * @param authorEntity Entidad de autor
     * @return Dto de autor
     */
    AuthorDto toAuthorDto(AuthorEntity authorEntity);

    /**
     * Contierte un DTO a una Entidad de autor
     * @param authorDto Dto de autor
     * @return Entidad de autor
     */
    @Mapping(target = "bookEntities", ignore = true)
    AuthorEntity toAuthorEntity(AuthorDto authorDto);

    /**
     * Convierte una lista de Entidades a una lista de Dtos
     * @param authorEntities Lista de entidades de autor
     * @return Lista de Dto de autor
     */
    List<AuthorDto> toAuthorDtoList(List<AuthorEntity> authorEntities);

}