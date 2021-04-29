package com.moviesandchill.film.service.service;

import com.moviesandchill.film.service.domain.FilmPageDto;
import com.moviesandchill.film.service.dto.*;

import java.util.List;
import java.util.Set;

public interface FilmService {

    List<FilmDto> getAllFilm();

    List<FilmPageDto> getAllPageFilm();

    List<FilmPageDto> getFirstPopularFilms();

    List<FilmPageDto> getFirstNewFilms();

    List<FilmPageDto> getRandomThreeFilms();

    void deleteAllFilm();

    FilmDto getFilmById(Long film_id);

    FilmDto addFilm(FilmDto film_dto);

    void deleteFilmById(Long film_id);

    List<GenreDto> getAllGenreWithFilm(Long film_id);

    float getRatingFilmById(Long film_id);

    AgeLimitDto getAgeLimitByFilmId(Long film_id);

    void setAgeLimitByFilmId(Long film_id,Long ageLimitID) throws Exception;

    CountryDto getCountryByFilmId(Long film_id);

    void setCountryByFilmId(Long film_id,Long countryID) throws Exception;

    void addGenreToFilm(Long film_id,Long genre_id) throws Exception;

    List<StaffDto> getAllStaffWithFilm(Long film_id);

    List<StaffDto> getAllActorsByFilm(Long film_id) throws Exception;

    List<StaffDto> getAllProducersByFilm(Long film_id) throws Exception;

    void addStaffToFilm(Long film_id,Long staff_id) throws Exception;

    List<ViewHistoryDto> getAllViewHistoryWithFilm(Long film_id);

    void addViewHistoryToFilm(Long film_id,Long viewHistory_id) throws Exception;

    List<ReviewDto> getAllReviewWithFilm(Long film_id);

    void addReviewToFilm(Long film_id,Long review_id) throws Exception;

    List<ScreenshotDto> getAllScreenshotWithFilm(Long film_id);

    void addScreenshotToFilm(Long film_id,Long screenshot_id) throws Exception;
}
