package com.reserva_libros.domain.dto;

public class BookRequestDto {

    private Integer bookId;
    private Integer authorId; // string
    private Integer categoryId;
    private String title;
    private String description;
    private String imagePath;
    private Integer yearOfPublication;
    private Integer active;

    public BookRequestDto() {
    }

    public BookRequestDto(Integer bookId, Integer authorId, Integer categoryId,
                          String title, String description, String imagePath,
                          Integer yearOfPublication, Integer active) {
        this.bookId = bookId;
        this.authorId = authorId;
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
        this.yearOfPublication = yearOfPublication;
        this.active = active;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}