package com.kbnproject.literalura.controller;

import com.kbnproject.literalura.model.Author;
import com.kbnproject.literalura.model.Book;
import com.kbnproject.literalura.repository.AuthorRepository;
import com.kbnproject.literalura.repository.BookRepository;
import com.kbnproject.literalura.service.DataCast;
import com.kbnproject.literalura.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BooksController {
    private final RequestService requestService;
    private final DataCast dataCast;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BooksController(RequestService requestService, DataCast dataCast, BookRepository bookRepository, AuthorRepository authorRepository){
        this.requestService = requestService;
        this.dataCast = dataCast;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public String getBook(String title){
        return requestService.requestBook(title);
    }

    public <T> T toObject(String json, Class<T> tClass){
        return dataCast.toObject(json, tClass);
    }

    public Book saveBook(Book e) {
        return bookRepository.save(e);
    }

    public Book getBookRepository(String title){
        return bookRepository.findByTitle(title);
    }

    public Author getAuthorRepository(String next) {
        return authorRepository.findByName(next);
    }

    public Author getAuthorByYear(int i) {
        return authorRepository.findByBirthDate(i);
    }

    public Book getBookByLanguage(String upperCase) {
        return bookRepository.findByLanguage(upperCase);
    }
}
