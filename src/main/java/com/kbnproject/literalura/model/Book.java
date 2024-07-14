package com.kbnproject.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @ElementCollection(targetClass = ELanguage.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<ELanguage> language;

    private int downloads;

    public Book(){}

    public Book(DataBook dataBook) {
        this.title = dataBook.title();
//        this.language = ELanguage.fromJson(dataBook.languages());
        this.authors = dataBook.authors().stream()
                .map(Author::new)
                .collect(Collectors.toList());
        this.language = dataBook.languages().stream()
                .map(ELanguage::fromJson)
                .collect(Collectors.toList());
        this.downloads = dataBook.downloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<ELanguage> getLanguage() {
        return language;
    }

    public void setLanguage(List<ELanguage> language) {
        this.language = language;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors= [" + authors + "]" +
                ", language=" + language +
                ", downloads=" + downloads +
                '}';
    }
}
