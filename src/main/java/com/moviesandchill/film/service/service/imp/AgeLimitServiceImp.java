package com.moviesandchill.film.service.service.imp;

import com.moviesandchill.film.service.domain.AgeLimit;
import com.moviesandchill.film.service.domain.Film;
import com.moviesandchill.film.service.dto.AgeLimitDto;
import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.mapper.AgeLimitMapper;
import com.moviesandchill.film.service.mapper.FilmMapper;
import com.moviesandchill.film.service.repositories.AgeLimitRepository;
import com.moviesandchill.film.service.repositories.FilmRepository;
import com.moviesandchill.film.service.service.AgeLimitService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgeLimitServiceImp implements AgeLimitService {

    @Autowired
    AgeLimitRepository ageRepository;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    AgeLimitMapper ageMapper;
    @Autowired
    FilmMapper filmMapper ;


    @Override
    public List<AgeLimitDto> getAllAgeLimit() {
        List<AgeLimit> age_limits = ageRepository.findAll();
        return ageMapper.listAgeLimitToListDto(age_limits);
    }

    @Override
    public void deleteAllAgeLimit() {
        ageRepository.deleteAll();
    }

    @Override
    public AgeLimitDto getAgeLimitById(Long agelimit_id) {
        Optional<AgeLimit> age_limit = ageRepository.findById(agelimit_id);
        return age_limit.map(ageMapper::ageLimitToDto).orElse(null);
    }

    @Override
    public AgeLimitDto addAgeLimit(AgeLimitDto agelimit_dto) {
        AgeLimit age_limit = ageMapper.dtoToAgeLimit(agelimit_dto);
        age_limit = ageRepository.save(age_limit);
        return ageMapper.ageLimitToDto(age_limit);
    }

    @Override
    public void deleteAgeLimitById(Long agelimit_id) {
        ageRepository.deleteById(agelimit_id);
    }

    @Override
    public List<FilmDto> getAllFilmsWithAgeLimit(Long agelimit_id) {
        Optional<AgeLimit> age_limit = ageRepository.findById(agelimit_id);
        if (age_limit.isPresent()) {
            List<Film> films = new ArrayList<>(age_limit.get().getFilms());
            return filmMapper.listFilmToListDto(films);
        }
        return null;
    }

    @Override
    public void addFilmToAgeLimit(Long film_id, Long agelimit_id) throws Exception {
        Film film = filmRepository.findById(film_id).orElseThrow(() -> new Exception());
        AgeLimit age_limit = ageRepository.findById(agelimit_id).orElseThrow(() -> new Exception());
        age_limit.getFilms().add(film);
        ageRepository.save(age_limit);
    }
}
