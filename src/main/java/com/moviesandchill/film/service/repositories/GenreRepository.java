package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
