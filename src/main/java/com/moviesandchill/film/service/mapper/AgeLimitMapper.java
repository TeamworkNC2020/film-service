package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Age_limit;
import com.moviesandchill.film.service.dto.AgeLimitDto;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AgeLimitMapper {

    Age_limit dtoToAgeLimit(AgeLimitDto age_limit_dto);

    AgeLimitDto ageLimitToDto(Age_limit age_limit);

    List<Age_limit> listDtoToListAgeLimit(List<AgeLimitDto> list_age_limit_dto);

    List<AgeLimitDto> listAgeLimitToListDto(List<Age_limit> list_age_limit);

}
