package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Film;
import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.dto.FilmDto.FilmDtoBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-12T15:23:31+0300",
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

        if ( filmDto.getIdFilm() != null ) {
            film.setIdFilm( filmDto.getIdFilm() );
        }
        if ( filmDto.getFilmTitle() != null ) {
            film.setFilmTitle( filmDto.getFilmTitle() );
        }
        if ( filmDto.getDuration() != null ) {
            film.setDuration( filmDto.getDuration() );
        }
        if ( filmDto.getReleaseDate() != null ) {
            film.setReleaseDate( filmDto.getReleaseDate() );
        }
        if ( filmDto.getFilmPoster() != null ) {
            film.setFilmPoster( filmDto.getFilmPoster() );
        }
        if ( filmDto.getFilmTrailer() != null ) {
            film.setFilmTrailer( filmDto.getFilmTrailer() );
        }
        if ( filmDto.getFilmVideo() != null ) {
            film.setFilmVideo( filmDto.getFilmVideo() );
        }
        if ( filmDto.getFilmBudget() != null ) {
            film.setFilmBudget( filmDto.getFilmBudget() );
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

        FilmDtoBuilder filmDto = FilmDto.builder();

        if ( film.getIdFilm() != null ) {
            filmDto.idFilm( film.getIdFilm() );
        }
        if ( film.getFilmTitle() != null ) {
            filmDto.filmTitle( film.getFilmTitle() );
        }
        if ( film.getDuration() != null ) {
            filmDto.duration( film.getDuration() );
        }
        if ( film.getReleaseDate() != null ) {
            filmDto.releaseDate( film.getReleaseDate() );
        }
        if ( film.getFilmPoster() != null ) {
            filmDto.filmPoster( film.getFilmPoster() );
        }
        if ( film.getFilmTrailer() != null ) {
            filmDto.filmTrailer( film.getFilmTrailer() );
        }
        if ( film.getFilmVideo() != null ) {
            filmDto.filmVideo( film.getFilmVideo() );
        }
        if ( film.getFilmBudget() != null ) {
            filmDto.filmBudget( film.getFilmBudget() );
        }
        if ( film.getDescription() != null ) {
            filmDto.description( film.getDescription() );
        }

        return filmDto.build();
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
