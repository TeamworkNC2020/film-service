package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {

   @Query(value = "SELECT avg(r.rating_film) FROM Review r where r.fk_film= ?1 group by r.fk_film;", nativeQuery = true)
   List<Object[]> findRatingFilmById(Long filmID);
}
