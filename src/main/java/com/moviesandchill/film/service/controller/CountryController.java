package com.moviesandchill.film.service.controller;

import com.moviesandchill.film.service.dto.CountryDto;
import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(
        path = "/countries",
        produces = "application/json"
)
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryDto> getAllCountry() {
        return countryService.getAllCountry();
    }

    @DeleteMapping
    public void deleteAllCountry() {
        countryService.deleteAllCountry();
    }

    @GetMapping("/{countryId}")
    public CountryDto getCountryById(@PathVariable Long countryId) {
        return countryService.getCountryById(countryId);
    }

    @PostMapping
    public CountryDto addCountry(@RequestBody CountryDto countryDto) {
        return countryService.addCountry(countryDto);
    }

    @DeleteMapping("/{countryId}")
    public void deleteCountryById(@PathVariable Long countryId) {
       countryService.deleteCountryById(countryId);
    }

    @GetMapping("/{countryId}/films")
    public List<FilmDto> getAllFilmsWithCountry(@PathVariable Long countryId) {
        return countryService.getAllFilmsWithCountry(countryId);
    }

    @PostMapping("/{countryId}/addFilm/{filmId}")
    public void addFilmToCountry(@PathVariable Long countryId ,@PathVariable Long filmId) throws Exception {
        countryService.addFilmToCountry(filmId,countryId);
    }
}
