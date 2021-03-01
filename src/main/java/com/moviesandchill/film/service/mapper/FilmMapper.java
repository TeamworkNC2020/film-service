package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Film;
import com.moviesandchill.film.service.dto.FilmDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FilmMapper {

    Film dtoToFilm(FilmDto film_dto);

    FilmDto filmToDto(Film film);

    List<Film> listDtoToListFilm(List<FilmDto> list_film_dto);

    List<FilmDto> listFilmToListDto(List<Film> list_film);
}
