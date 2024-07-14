package com.kbnproject.literalura.repository;

import com.kbnproject.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByName(String next);

    Author findByBirthDate(int i);
}
