package com.kbnproject.literalura.model;

import jakarta.persistence.*;

import java.time.Year;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer birthDate;

    private Integer deathDate;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books;

    public Author(){}

    public Author(DataAuthor dataAuthor) {
        this.name = dataAuthor.name();
        try {
//            this.birthDate = LocalDate.parse(dataAuthor.birthDate().toString(), DateTimeFormatter.ofPattern("yyyy"));
            this.birthDate = dataAuthor.birthDate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
//            this.deathDate = LocalDate.parse(dataAuthor.deathDate().toString(), DateTimeFormatter.ofPattern("yyyy"));
            this.deathDate = dataAuthor.deathDate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Integer deathDate) {
        this.deathDate = deathDate;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                '}';
    }
}
