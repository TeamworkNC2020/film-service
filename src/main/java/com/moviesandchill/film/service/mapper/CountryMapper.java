package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Country;
import com.moviesandchill.film.service.dto.CountryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CountryMapper {

    Country dtoToCountry(CountryDto country_dto);

    CountryDto countryToDto(Country country);

    List<Country> listDtoToListCountry(List<CountryDto> list_country_dto);

    List<CountryDto> listCountryToListDto(List<Country> list_country);
}
