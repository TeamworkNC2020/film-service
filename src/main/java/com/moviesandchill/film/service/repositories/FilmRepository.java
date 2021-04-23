package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query("SELECT avg(rating_film) FROM Review where fk_film=?1 group by fk_film;")
    List<Object[]> findRatingFilmById(Long filmID);
}
