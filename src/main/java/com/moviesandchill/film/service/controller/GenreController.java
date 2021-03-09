package com.moviesandchill.film.service.controller;

import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.dto.GenreDto;
import com.moviesandchill.film.service.service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping(
        path = "/genres",
        produces = "application/json"
)
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<GenreDto> getAllGenre() {
        return genreService.getAllGenre();
    }

    @DeleteMapping
    public void deleteAllGenre() {
        genreService.deleteAllGenre();
    }

    @GetMapping("/{genreId}")
    public GenreDto getGenreById(@PathVariable Long genreId) {
        return genreService.getGenreById(genreId);
    }

    @PostMapping
    public GenreDto addGenre(@RequestBody GenreDto genreDto) {
        return genreService.addGenre(genreDto);
    }

    @DeleteMapping("/{genreId}")
    public void deleteGenreById(@PathVariable Long genreId) {
        genreService.deleteGenreById(genreId);
    }

    @GetMapping("/{genreId}/films")
    public Set<FilmDto> getAllFilmWithGenre(@PathVariable Long genreId) {
        return genreService.getAllFilmWithGenre(genreId);
    }

    @PostMapping("/{genreId}/addFilm/{filmId}")
    public void addFilmToGenre(@PathVariable Long genreId,@PathVariable Long filmId) throws Exception {
        genreService.addFilmToGenre(filmId,genreId);
    }
}
