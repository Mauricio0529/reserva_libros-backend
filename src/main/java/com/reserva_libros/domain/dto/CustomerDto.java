package com.reserva_libros.domain.dto;

/**
 * DTO de usuarios
 */

public class CustomerDto {

    /**
     * cedula de usuario
     */
    private Integer cardId;
    private String name;
    private String lestName;
    private String username; // sobra
    private String password;
    private String email;
    private Integer active;
    private String rol;
    private Double numberCellPhone;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLestName() {
        return lestName;
    }

    public void setLestName(String lestName) {
        this.lestName = lestName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Double getNumberCellPhone() {
        return numberCellPhone;
    }

    public void setNumberCellPhone(Double numberCellPhone) {
        this.numberCellPhone = numberCellPhone;
    }
}