package com.moviesandchill.film.service.controller;

import com.moviesandchill.film.service.dto.FilmPageDto;
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

    @GetMapping("/allpage")
    public List<FilmPageDto> getAllPageFilm() {
        return filmService.getAllPageFilm();
    }

    @GetMapping("/newfilms")
    public List<FilmPageDto> getFirstNewFilms() {
        return filmService.getFirstNewFilms();
    }

    @GetMapping("/randomthreefilms")
    public List<RandFilmDto> getRandomThreeFilms() {
        return filmService.getRandomThreeFilms();
    }

    @GetMapping("/popularfilms")
    public List<FilmPageDto> getFirstPopularFilms() {
        return filmService.getFirstPopularFilms();
    }

    @DeleteMapping
    public void deleteAllFilm() {
        filmService.deleteAllFilm();
    }

    @GetMapping("/{filmId}")
    public FilmDto getFilmById(@PathVariable Long filmId) {
        return filmService.getFilmById(filmId);
    }

    @GetMapping("/ratingFilm/{filmId}")
    public float getRatingFilmById(@PathVariable Long filmId) {
        return filmService.getRatingFilmById(filmId);
    }

    @GetMapping("/{filmId}/actors")
    public List<StaffDto> getAllActorsByFilm(@PathVariable Long filmId) throws Exception {
        return filmService.getAllActorsByFilm(filmId);
    }

    @GetMapping("/{filmId}/producers")
    public List<StaffDto> getAllProducersByFilm(@PathVariable Long filmId) throws Exception{
        return filmService.getAllProducersByFilm(filmId);
    }

    @GetMapping("/{filmId}/ageLimit")
    public AgeLimitDto getAgeLimitByFilmId(@PathVariable Long filmId) {
        return filmService.getAgeLimitByFilmId(filmId);
    }

    @PostMapping("/{filmId}/setAgeLimit/{ageLimitID}")
    public void setAgeLimitByFilmId(@PathVariable Long filmId,@PathVariable  Long ageLimitID) throws Exception {
        filmService.setAgeLimitByFilmId(filmId,ageLimitID);
    }

    @GetMapping("/{filmId}/country")
    public CountryDto getCountryByFilmId(@PathVariable Long filmId) {
        return filmService.getCountryByFilmId(filmId);
    }

    @PostMapping("/{filmId}/setCountry/{countryID}")
    public void setCountryByFilmId(@PathVariable Long filmId,@PathVariable  Long countryID) throws Exception {
        filmService.setCountryByFilmId(filmId,countryID);
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
