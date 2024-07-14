package com.kbnproject.literalura.repository;

import com.kbnproject.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);

    Book findByLanguage(String upperCase);
}
