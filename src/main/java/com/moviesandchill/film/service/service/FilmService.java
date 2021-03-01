package com.moviesandchill.film.service.service;

import com.moviesandchill.film.service.dto.*;

import java.util.List;
import java.util.Set;

public interface FilmService {

    List<FilmDto> getAllFilm();

    void deleteAllFilm();

    FilmDto getFilmById(Long film_id);

    FilmDto addFilm(FilmDto film_dto);

    void deleteFilmById(Long film_id);

    Set<GenreDto> getAllGenreWithFilm(Long film_id);

    void addGenreToFilm(Long film_id,Long genre_id) throws Exception;

    Set<StaffDto> getAllStaffWithFilm(Long film_id);

    void addStaffToFilm(Long film_id,Long staff_id) throws Exception;

    List<ViewHistoryDto> getAllViewHistoryWithFilm(Long film_id);

    void addViewHistoryToFilm(Long film_id,Long viewHistory_id) throws Exception;

    List<ReviewDto> getAllReviewWithFilm(Long film_id);

    void addReviewToFilm(Long film_id,Long review_id) throws Exception;
}
