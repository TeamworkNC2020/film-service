package com.moviesandchill.film.service.service.imp;

import com.moviesandchill.film.service.domain.*;
import com.moviesandchill.film.service.dto.*;
import com.moviesandchill.film.service.mapper.*;
import com.moviesandchill.film.service.repositories.*;
import com.moviesandchill.film.service.service.FilmService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FilmServiceImp implements FilmService {

    @Autowired
    FilmRepository filmRepository;
    StaffRepository staffRepository;
    GenreRepository genreRepository;
    ViewHistoryRepository viewHistoryRepository;
    ReviewRepository reviewRepository;
    private final FilmMapper filmMapper = Mappers.getMapper(FilmMapper.class);
    private final StaffMapper staffMapper = Mappers.getMapper(StaffMapper.class);
    private final GenreMapper genreMapper = Mappers.getMapper(GenreMapper.class);
    private final ViewHistoryMapper viewHistoryMapper = Mappers.getMapper(ViewHistoryMapper.class);
    private final ReviewMapper reviewMapper = Mappers.getMapper(ReviewMapper.class);

    @Override
    public List<FilmDto> getAllFilm() {
        List<Film> films = filmRepository.findAll();
        return filmMapper.listFilmToListDto(films);
    }

    @Override
    public void deleteAllFilm() {
        filmRepository.deleteAll();
    }

    @Override
    public FilmDto getFilmById(Long film_id) {
        Optional<Film> film = filmRepository.findById(film_id);
        return film.map(filmMapper::filmToDto).orElse(null);
    }

    @Override
    public FilmDto addFilm(FilmDto film_dto) {
        Film film = filmMapper.dtoToFilm(film_dto);
        film = filmRepository.save(film);
        return filmMapper.filmToDto(film);
    }

    @Override
    public void deleteFilmById(Long film_id) {
        filmRepository.deleteById(film_id);
    }

    @Override
    public Set<GenreDto> getAllGenreWithFilm(Long film_id) {
        Optional<Film> film = filmRepository.findById(film_id);
        if (film.isPresent()) {
            Set<Genre> genres = new HashSet<>(film.get().getGenres());
            return genreMapper.setGenreToSetDto(genres);
        }
        return null;
    }

    @Override
    public void addGenreToFilm(Long film_id, Long genre_id) throws Exception {
        Film film = filmRepository.findById(film_id).orElseThrow(() -> new Exception());
        Genre genre = genreRepository.findById(genre_id).orElseThrow(() -> new Exception());
        film.getGenres().add(genre);
        filmRepository.save(film);
        genre.getFilms().add(film);
        genreRepository.save(genre);
    }

    @Override
    public Set<StaffDto> getAllStaffWithFilm(Long film_id) {
        Optional<Film> film = filmRepository.findById(film_id);
        if (film.isPresent()) {
            Set<Staff> staffs = new HashSet<>(film.get().getStaffs());
            return staffMapper.setStaffToSetDto(staffs);
        }
        return null;
    }

    @Override
    public void addStaffToFilm(Long film_id, Long staff_id) throws Exception {
        Film film = filmRepository.findById(film_id).orElseThrow(() -> new Exception());
        Staff staff = staffRepository.findById(staff_id).orElseThrow(() -> new Exception());
        film.getStaffs().add(staff);
        filmRepository.save(film);
        staff.getFilms().add(film);
        staffRepository.save(staff);
    }

    @Override
    public List<ViewHistoryDto> getAllViewHistoryWithFilm(Long film_id) {
        Optional<Film> film = filmRepository.findById(film_id);
        if (film.isPresent()) {
            List<ViewHistory> viewHistorys = new ArrayList<>(film.get().getView_histories());
            return viewHistoryMapper.listViewHistoryToListDto(viewHistorys);
        }
        return null;
    }

    @Override
    public void addViewHistoryToFilm(Long film_id, Long viewHistory_id) throws Exception {
        Film film = filmRepository.findById(film_id).orElseThrow(() -> new Exception());
        ViewHistory viewHistory = viewHistoryRepository.findById(viewHistory_id).orElseThrow(() -> new Exception());
        film.getView_histories().add(viewHistory);
        filmRepository.save(film);
    }

    @Override
    public List<ReviewDto> getAllReviewWithFilm(Long film_id) {
        Optional<Film> film = filmRepository.findById(film_id);
        if (film.isPresent()) {
            List<Review> reviews = new ArrayList<>(film.get().getReviews());
            return reviewMapper.listReviewToListDto(reviews);
        }
        return null;
    }

    @Override
    public void addReviewToFilm(Long film_id, Long review_id) throws Exception {
        Film film = filmRepository.findById(film_id).orElseThrow(() -> new Exception());
        Review review = reviewRepository.findById(review_id).orElseThrow(() -> new Exception());
        film.getReviews().add(review);
        filmRepository.save(film);
    }
}
