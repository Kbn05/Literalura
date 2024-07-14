package com.kbnproject.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataAuthor(@JsonAlias("name") String name, @JsonAlias("birth_year") Integer birthDate, @JsonAlias("death_year") Integer deathDate) {
}
