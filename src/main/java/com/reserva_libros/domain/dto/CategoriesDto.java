package com.reserva_libros.domain.dto;

/**
 * DTO de categoria
 */

public class CategoriesDto {

    private Integer id_categoria;

    private String nameCategory;

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}