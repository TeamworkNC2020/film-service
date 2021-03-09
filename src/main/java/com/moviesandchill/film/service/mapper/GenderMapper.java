package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Gender;
import com.moviesandchill.film.service.dto.GenderDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface GenderMapper {

    Gender dtoToGender(GenderDto genderDto);

    GenderDto genderToDto(Gender gender);

    List<Gender> listDtoToListGender(List<GenderDto> listGenderDto);

    List<GenderDto> listGenderToListDto(List<Gender> listGender);
}
