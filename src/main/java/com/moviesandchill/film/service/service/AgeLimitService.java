package com.moviesandchill.film.service.service;

import com.moviesandchill.film.service.dto.AgeLimitDto;
import com.moviesandchill.film.service.dto.FilmDto;

import java.util.List;

public interface AgeLimitService {

    List<AgeLimitDto> getAllAgeLimit();

    void deleteAllAgeLimit();

    AgeLimitDto getAgeLimitById(Long agelimit_id);

    AgeLimitDto addAgeLimit(AgeLimitDto agelimit_dto);

    void deleteAgeLimitById(Long agelimit_id);

    List<FilmDto> getAllFilmsWithAgeLimit(Long agelimit_id);

    void addFilmToAgeLimit(Long film_id,Long agelimit_id) throws Exception;
}
