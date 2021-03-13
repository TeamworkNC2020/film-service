package com.moviesandchill.film.service.service.imp;

import com.moviesandchill.film.service.domain.Film;
import com.moviesandchill.film.service.domain.Genre;
import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.dto.GenreDto;
import com.moviesandchill.film.service.mapper.*;
import com.moviesandchill.film.service.repositories.*;
import com.moviesandchill.film.service.service.GenreService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GenreServiceImp implements GenreService {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    FilmMapper filmMapper;
    @Autowired
    GenreMapper genreMapper;

    @Override
    public List<GenreDto> getAllGenre() {
        List<Genre> genres = genreRepository.findAll();
        return genreMapper.listGenreToListDto(genres);
    }

    @Override
    public void deleteAllGenre() {
        genreRepository.deleteAll();
    }

    @Override
    public GenreDto getGenreById(Long genreId) {
        Optional<Genre> genre = genreRepository.findById(genreId);
        return genre.map(genreMapper::genreToDto).orElse(null);
    }

    @Override
    public GenreDto addGenre(GenreDto genreDto) {
        Genre genre = genreMapper.dtoToGenre(genreDto);
        genre = genreRepository.save(genre);
        return genreMapper.genreToDto(genre);
    }

    @Override
    public void deleteGenreById(Long genreId) {
        genreRepository.deleteById(genreId);
    }

    @Override
    public List<FilmDto> getAllFilmWithGenre(Long genreId) {
        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            List<Film> films = new ArrayList<>(genre.get().getFilms());
            return filmMapper.listFilmToListDto(films);
        }
        return null;
    }

    @Override
    public void addFilmToGenre(Long filmId, Long genreId) throws Exception {
        Film film = filmRepository.findById(filmId).orElseThrow(()->new Exception());
        Genre genre = genreRepository.findById(genreId).orElseThrow(()->new Exception());
        genre.getFilms().add(film);
        genreRepository.save(genre);
        film.getGenres().add(genre);
        filmRepository.save(film);
    }
}
