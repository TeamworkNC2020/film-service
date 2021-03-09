package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Film;
import com.moviesandchill.film.service.dto.FilmDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface FilmMapper {

    Film dtoToFilm(FilmDto filmDto);

    FilmDto filmToDto(Film film);

    List<Film> listDtoToListFilm(List<FilmDto> listFilmDto);

    List<FilmDto> listFilmToListDto(List<Film> listFilm);

    Set<Film> setDtoToSetFilm(Set<FilmDto> setFilmDto);

    Set<FilmDto> setFilmToSetDto(Set<Film> setFilm);
}
