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
    private String surnames;
    private String username;
    private String password;
    private String email;
    // private Integer active
    // private String rol;
    private Integer numberCellPhone; // Double

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

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
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

    public Integer getNumberCellPhone() {
        return numberCellPhone;
    }

    public void setNumberCellPhone(Integer numberCellPhone) {
        this.numberCellPhone = numberCellPhone;
    }
}