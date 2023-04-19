package com.reserva_libros.domain.dto;

public class CategoriesDto {

    /**
     * DTO de categoria
     */
    private Integer id;
    private String nameCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}