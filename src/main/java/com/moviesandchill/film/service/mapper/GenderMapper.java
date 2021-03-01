package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Gender;
import com.moviesandchill.film.service.dto.GenderDto;
import org.mapstruct.Mapper;

@Mapper
public interface GenderMapper {

    Gender dtoToGender(GenderDto gender_dto);

    GenderDto genderToDto(Gender gender);
}
