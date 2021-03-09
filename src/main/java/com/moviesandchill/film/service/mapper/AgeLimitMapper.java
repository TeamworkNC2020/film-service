package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.AgeLimit;
import com.moviesandchill.film.service.dto.AgeLimitDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface AgeLimitMapper {

    AgeLimit dtoToAgeLimit(AgeLimitDto age_limit_dto);

    AgeLimitDto ageLimitToDto(AgeLimit age_limit);

    List<AgeLimit> listDtoToListAgeLimit(List<AgeLimitDto> list_age_limit_dto);

    List<AgeLimitDto> listAgeLimitToListDto(List<AgeLimit> list_age_limit);

}
