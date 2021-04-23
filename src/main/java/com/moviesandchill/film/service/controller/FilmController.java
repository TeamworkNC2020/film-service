package com.moviesandchill.film.service.controller;

import com.moviesandchill.film.service.dto.*;
import com.moviesandchill.film.service.service.FilmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(
        path = "/films",
        produces = "application/json"
)
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public List<FilmDto> getAllFilm() {
        return filmService.getAllFilm();
    }

    @DeleteMapping
    public void deleteAllFilm() {
        filmService.deleteAllFilm();
    }

    @GetMapping("/{filmId}")
    public FilmDto getFilmById(@PathVariable Long filmId) {
        return filmService.getFilmById(filmId);
    }

    @PostMapping
    public FilmDto addFilm(@RequestBody FilmDto filmDto) {
        return filmService.addFilm(filmDto);
    }

    @DeleteMapping("/{filmId}")
    public void deleteFilmById(@PathVariable Long filmId) {
        filmService.deleteFilmById(filmId);
    }

    @GetMapping("/{filmId}/genres")
    public List<GenreDto> getAllGenreWithFilm(@PathVariable Long filmId) {
        return filmService.getAllGenreWithFilm(filmId);
    }

    @PostMapping("/{filmId}/addGenre/{genreId}")
    public void addGenreToFilm(@PathVariable Long filmId,@PathVariable Long genreId) throws Exception {
        filmService.addGenreToFilm(filmId,genreId);
    }

    @GetMapping("/{filmId}/staffs")
    public List<StaffDto> getAllStaffWithFilm(@PathVariable Long filmId) {
        return filmService.getAllStaffWithFilm(filmId);
    }

    @PostMapping("/{filmId}/addStaff/{staffId}")
    public void addStaffToFilm(@PathVariable Long filmId,@PathVariable Long staffId) throws Exception {
        filmService.addStaffToFilm(filmId,staffId);
    }

    @GetMapping("/{filmId}/viewHistories")
    public List<ViewHistoryDto> getAllViewHistoryWithFilm(@PathVariable Long filmId) {
        return filmService.getAllViewHistoryWithFilm(filmId);
    }

    @PostMapping("/{filmId}/addViewHistory/{viewHistoryId}")
    public void addViewHistoryToFilm(@PathVariable Long filmId,@PathVariable Long viewHistoryId) throws Exception {
        filmService.addViewHistoryToFilm(filmId,viewHistoryId);
    }

    @GetMapping("/{filmId}/reviews")
    public List<ReviewDto> getAllReviewWithFilm(@PathVariable Long filmId) {
        return filmService.getAllReviewWithFilm(filmId);
    }

    @PostMapping("/{filmId}/addReview/{reviewId}")
    public void addReviewToFilm(@PathVariable Long filmId,@PathVariable Long reviewId) throws Exception {
        filmService.addReviewToFilm(filmId,reviewId);
    }

    @GetMapping("/{filmId}/screenshots")
    public List<ScreenshotDto> getAllScreenshotWithFilm(@PathVariable Long filmId) {
        return filmService.getAllScreenshotWithFilm(filmId);
    }

    @PostMapping("/{filmId}/addScreenshot/{screenshotId}")
    public void addScreenshotToFilm(@PathVariable Long filmId,@PathVariable Long screenshotId) throws Exception {
        filmService.addScreenshotToFilm(filmId,screenshotId);
    }
}
