package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Gender;
import com.moviesandchill.film.service.dto.GenderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GenderMapper {

    Gender dtoToGender(GenderDto genderDto);

    GenderDto genderToDto(Gender gender);

    List<Gender> listDtoToListGender(List<GenderDto> listGenderDto);

    List<GenderDto> listGenderToListDto(List<Gender> listGender);
}
