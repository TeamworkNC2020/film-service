package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Genre;
import com.moviesandchill.film.service.dto.GenreDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-05T15:02:55+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
public class GenreMapperImpl implements GenreMapper {

    @Override
    public Genre dtoToGenre(GenreDto genre_dto) {
        if ( genre_dto == null ) {
            return null;
        }

        Genre genre = new Genre();

        return genre;
    }

    @Override
    public GenreDto genreToDto(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreDto genreDto = new GenreDto();

        return genreDto;
    }

    @Override
    public List<Genre> listDtoToListGenre(List<GenreDto> list_genre_dto) {
        if ( list_genre_dto == null ) {
            return null;
        }

        List<Genre> list = new ArrayList<Genre>( list_genre_dto.size() );
        for ( GenreDto genreDto : list_genre_dto ) {
            list.add( dtoToGenre( genreDto ) );
        }

        return list;
    }

    @Override
    public List<GenreDto> listGenreToListDto(List<Genre> list_genre) {
        if ( list_genre == null ) {
            return null;
        }

        List<GenreDto> list = new ArrayList<GenreDto>( list_genre.size() );
        for ( Genre genre : list_genre ) {
            list.add( genreToDto( genre ) );
        }

        return list;
    }

    @Override
    public Set<Genre> setDtoToSetGenre(Set<GenreDto> set_genre_dto) {
        if ( set_genre_dto == null ) {
            return null;
        }

        Set<Genre> set = new HashSet<Genre>( Math.max( (int) ( set_genre_dto.size() / .75f ) + 1, 16 ) );
        for ( GenreDto genreDto : set_genre_dto ) {
            set.add( dtoToGenre( genreDto ) );
        }

        return set;
    }

    @Override
    public Set<GenreDto> setGenreToSetDto(Set<Genre> set_genre) {
        if ( set_genre == null ) {
            return null;
        }

        Set<GenreDto> set = new HashSet<GenreDto>( Math.max( (int) ( set_genre.size() / .75f ) + 1, 16 ) );
        for ( Genre genre : set_genre ) {
            set.add( genreToDto( genre ) );
        }

        return set;
    }
}
