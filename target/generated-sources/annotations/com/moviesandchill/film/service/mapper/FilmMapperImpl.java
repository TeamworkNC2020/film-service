package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Film;
import com.moviesandchill.film.service.dto.FilmDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-05T15:02:56+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
public class FilmMapperImpl implements FilmMapper {

    @Override
    public Film dtoToFilm(FilmDto filmDto) {
        if ( filmDto == null ) {
            return null;
        }

        Film film = new Film();

        return film;
    }

    @Override
    public FilmDto filmToDto(Film film) {
        if ( film == null ) {
            return null;
        }

        FilmDto filmDto = new FilmDto();

        return filmDto;
    }

    @Override
    public List<Film> listDtoToListFilm(List<FilmDto> listFilmDto) {
        if ( listFilmDto == null ) {
            return null;
        }

        List<Film> list = new ArrayList<Film>( listFilmDto.size() );
        for ( FilmDto filmDto : listFilmDto ) {
            list.add( dtoToFilm( filmDto ) );
        }

        return list;
    }

    @Override
    public List<FilmDto> listFilmToListDto(List<Film> listFilm) {
        if ( listFilm == null ) {
            return null;
        }

        List<FilmDto> list = new ArrayList<FilmDto>( listFilm.size() );
        for ( Film film : listFilm ) {
            list.add( filmToDto( film ) );
        }

        return list;
    }

    @Override
    public Set<Film> setDtoToSetFilm(Set<FilmDto> setFilmDto) {
        if ( setFilmDto == null ) {
            return null;
        }

        Set<Film> set = new HashSet<Film>( Math.max( (int) ( setFilmDto.size() / .75f ) + 1, 16 ) );
        for ( FilmDto filmDto : setFilmDto ) {
            set.add( dtoToFilm( filmDto ) );
        }

        return set;
    }

    @Override
    public Set<FilmDto> setFilmToSetDto(Set<Film> setFilm) {
        if ( setFilm == null ) {
            return null;
        }

        Set<FilmDto> set = new HashSet<FilmDto>( Math.max( (int) ( setFilm.size() / .75f ) + 1, 16 ) );
        for ( Film film : setFilm ) {
            set.add( filmToDto( film ) );
        }

        return set;
    }
}
