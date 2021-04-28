package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.Film;
import com.moviesandchill.film.service.dto.FilmDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {

   @Query("SELECT avg(r.ratingFilm) FROM Review r where r.film.idFilm= ?1 group by r.film.idFilm")
   List<Object[]> findRatingFilmById(Long filmID);

   @Query("SELECT   r.film.idFilm as fkFilm, avg(r.ratingFilm) as rating\n" +
           "\t\t\tFROM Review r\t  \t\t\n" +
           "\t\t\tgroup by r.film.idFilm")
   List<Object[]> findPopularIdFilm(Pageable page);

   @Query("select f from Film f where f.idFilm in :ids")
   List<Film> findFilmIds(@Param("ids") Iterable<Long> ids);
}
