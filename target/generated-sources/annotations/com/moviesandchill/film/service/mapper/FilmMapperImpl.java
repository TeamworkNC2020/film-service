package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Film;
import com.moviesandchill.film.service.dto.FilmDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-13T10:50:31+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class FilmMapperImpl implements FilmMapper {

    @Override
    public Film dtoToFilm(FilmDto filmDto) {
        if ( filmDto == null ) {
            return null;
        }

        Film film = new Film();

        if ( filmDto.getId_film() != null ) {
            film.setId_film( filmDto.getId_film() );
        }
        if ( filmDto.getFilm_title() != null ) {
            film.setFilm_title( filmDto.getFilm_title() );
        }
        if ( filmDto.getDuration() != null ) {
            film.setDuration( filmDto.getDuration() );
        }
        if ( filmDto.getRelease_date() != null ) {
            film.setRelease_date( filmDto.getRelease_date() );
        }
        if ( filmDto.getFilm_poster() != null ) {
            film.setFilm_poster( filmDto.getFilm_poster() );
        }
        if ( filmDto.getFilm_trailer() != null ) {
            film.setFilm_trailer( filmDto.getFilm_trailer() );
        }
        if ( filmDto.getFilm_video() != null ) {
            film.setFilm_video( filmDto.getFilm_video() );
        }
        if ( filmDto.getFilm_budget() != null ) {
            film.setFilm_budget( filmDto.getFilm_budget() );
        }
        if ( filmDto.getDescription() != null ) {
            film.setDescription( filmDto.getDescription() );
        }

        return film;
    }

    @Override
    public FilmDto filmToDto(Film film) {
        if ( film == null ) {
            return null;
        }

        FilmDto filmDto = new FilmDto();

        if ( film.getId_film() != null ) {
            filmDto.setId_film( film.getId_film() );
        }
        if ( film.getFilm_title() != null ) {
            filmDto.setFilm_title( film.getFilm_title() );
        }
        if ( film.getDuration() != null ) {
            filmDto.setDuration( film.getDuration() );
        }
        if ( film.getRelease_date() != null ) {
            filmDto.setRelease_date( film.getRelease_date() );
        }
        if ( film.getFilm_poster() != null ) {
            filmDto.setFilm_poster( film.getFilm_poster() );
        }
        if ( film.getFilm_trailer() != null ) {
            filmDto.setFilm_trailer( film.getFilm_trailer() );
        }
        if ( film.getFilm_video() != null ) {
            filmDto.setFilm_video( film.getFilm_video() );
        }
        if ( film.getFilm_budget() != null ) {
            filmDto.setFilm_budget( film.getFilm_budget() );
        }
        if ( film.getDescription() != null ) {
            filmDto.setDescription( film.getDescription() );
        }

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
