package com.moviesandchill.film.service.service;

import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.dto.GenreDto;

import java.util.List;
import java.util.Set;

public interface GenreService {

    List<GenreDto> getAllGenre();

    void deleteAllGenre();

    GenreDto getGenreById(Long genreId);

    GenreDto addGenre(GenreDto genreDto);

    void deleteGenreById(Long genreId);

    List<FilmDto> getAllFilmWithGenre(Long genreId);

    void addFilmToGenre(Long filmId,Long genreId) throws Exception;
}
