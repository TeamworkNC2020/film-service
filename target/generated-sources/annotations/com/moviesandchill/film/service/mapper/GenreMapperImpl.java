package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Genre;
import com.moviesandchill.film.service.dto.GenreDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-05T17:17:56+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public Genre dtoToGenre(GenreDto genre_dto) {
        if ( genre_dto == null ) {
            return null;
        }

        Genre genre = new Genre();

        if ( genre_dto.getId_genre() != null ) {
            genre.setId_genre( genre_dto.getId_genre() );
        }
        if ( genre_dto.getGenre_title() != null ) {
            genre.setGenre_title( genre_dto.getGenre_title() );
        }

        return genre;
    }

    @Override
    public GenreDto genreToDto(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreDto genreDto = new GenreDto();

        if ( genre.getId_genre() != null ) {
            genreDto.setId_genre( genre.getId_genre() );
        }
        if ( genre.getGenre_title() != null ) {
            genreDto.setGenre_title( genre.getGenre_title() );
        }

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
