package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
