package com.moviesandchill.film.service.service;

import com.moviesandchill.film.service.dto.CountryDto;
import com.moviesandchill.film.service.dto.FilmDto;

import java.util.List;

public interface CountryService {

    List<CountryDto> getAllCountry();

    void deleteAllCountry();

    CountryDto getCountryById(Long country_id);

    CountryDto addCountry(CountryDto country_dto);

    void deleteCountryById(Long country_id);

    List<FilmDto> getAllFilmsWithCountry(Long country_id);

    void addFilmToCountry(Long film_id,Long country_id) throws Exception;
}
