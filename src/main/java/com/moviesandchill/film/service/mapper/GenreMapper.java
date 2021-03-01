package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Genre;
import com.moviesandchill.film.service.dto.GenreDto;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface GenreMapper {

    Genre dtoToGenre(GenreDto genre_dto);

    GenreDto genreToDto(Genre genre);

    List<Genre> listDtoToListGenre(List<GenreDto> list_genre_dto);

    List<GenreDto> listGenreToListDto(List<Genre> list_genre);

    Set<Genre> setDtoToSetGenre(Set<GenreDto> set_genre_dto);

    Set<GenreDto> setGenreToSetDto(Set<Genre> set_genre);
}
