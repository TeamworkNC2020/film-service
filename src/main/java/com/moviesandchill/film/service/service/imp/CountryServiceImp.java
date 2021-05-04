package com.moviesandchill.film.service.service.imp;

import com.moviesandchill.film.service.domain.Country;
import com.moviesandchill.film.service.domain.Film;
import com.moviesandchill.film.service.dto.CountryDto;
import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.mapper.AgeLimitMapper;
import com.moviesandchill.film.service.mapper.CountryMapper;
import com.moviesandchill.film.service.mapper.FilmMapper;
import com.moviesandchill.film.service.repositories.CountryRepository;
import com.moviesandchill.film.service.repositories.FilmRepository;
import com.moviesandchill.film.service.service.CountryService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImp implements CountryService {

    @Autowired
    CountryRepository countryRepository;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    CountryMapper countryMapper;
    @Autowired
    FilmMapper filmMapper;

    @Override
    public List<CountryDto> getAllCountry() {
        List<Country> countries = countryRepository.findAll();
        return countryMapper.listCountryToListDto(countries);
    }

    @Override
    public void deleteAllCountry() {
        countryRepository.deleteAll();
    }

    @Override
    public CountryDto getCountryById(Long country_id) {
        Optional<Country> country = countryRepository.findById(country_id);
        return country.map(countryMapper::countryToDto).orElse(null);
    }

    @Override
    public CountryDto addCountry(CountryDto country_dto) {
        Country country = countryMapper.dtoToCountry(country_dto);
        country = countryRepository.save(country);
        return countryMapper.countryToDto(country);
    }

    @Override
    public void deleteCountryById(Long country_id) {
        countryRepository.deleteById(country_id);
    }

    @Override
    public List<FilmDto> getAllFilmsWithCountry(Long country_id) {
        Optional<Country> country = countryRepository.findById(country_id);
        if (country.isPresent()) {
            List<Film> films = new ArrayList<>(country.get().getFilms());
            return filmMapper.listFilmToListDto(films);
        }
        return null;
    }

    @Override
    public void addFilmToCountry(Long film_id, Long country_id) throws Exception {
        Film film = filmRepository.findById(film_id).orElseThrow(() -> new Exception());
        Country country = countryRepository.findById(country_id).orElseThrow(() -> new Exception());
        film.setCountry(country);
        filmRepository.save(film);
    }
}
