package com.moviesandchill.film.service.controller;

import com.moviesandchill.film.service.dto.AgeLimitDto;
import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.service.AgeLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(
        path = "/ageLimits",
        produces = "application/json"
)
public class AgeLimitController {
    @Autowired
    AgeLimitService ageLimitService;

    @GetMapping
    public List<AgeLimitDto> getAllAgeLimit() {
        return ageLimitService.getAllAgeLimit();
    }

    @DeleteMapping
    public void deleteAllAgeLimit() {
        ageLimitService.deleteAllAgeLimit();
    }

    @GetMapping("/{ageLimitId}")
    public AgeLimitDto getAgeLimitById(@PathVariable Long ageLimitId) {
        return ageLimitService.getAgeLimitById(ageLimitId);
    }

    @PostMapping
    public AgeLimitDto addAgeLimit(@RequestBody AgeLimitDto ageLimitDto) {
        return ageLimitService.addAgeLimit(ageLimitDto);
    }

    @DeleteMapping("/{ageLimitId}")
    public void deleteAgeLimitById(@PathVariable Long ageLimitId) {
        ageLimitService.deleteAgeLimitById(ageLimitId);
    }

    @GetMapping("/{ageLimitId}/films")
    public List<FilmDto> getAllFilmsWithAgeLimit(@PathVariable Long ageLimitId) {
        return ageLimitService.getAllFilmsWithAgeLimit(ageLimitId);
    }

    @PostMapping("/{ageLimitId}/addFilm/{filmId}")
    public void addFilmToAgeLimit(@PathVariable Long ageLimitId,@PathVariable Long filmId) throws Exception {
        ageLimitService.addFilmToAgeLimit(filmId,ageLimitId);
    }
}
