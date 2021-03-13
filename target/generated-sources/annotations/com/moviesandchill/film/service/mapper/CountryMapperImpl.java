package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Country;
import com.moviesandchill.film.service.dto.CountryDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-13T10:50:31+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public Country dtoToCountry(CountryDto country_dto) {
        if ( country_dto == null ) {
            return null;
        }

        Country country = new Country();

        if ( country_dto.getId_country() != null ) {
            country.setId_country( country_dto.getId_country() );
        }
        if ( country_dto.getCountry_name() != null ) {
            country.setCountry_name( country_dto.getCountry_name() );
        }

        return country;
    }

    @Override
    public CountryDto countryToDto(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        if ( country.getId_country() != null ) {
            countryDto.setId_country( country.getId_country() );
        }
        if ( country.getCountry_name() != null ) {
            countryDto.setCountry_name( country.getCountry_name() );
        }

        return countryDto;
    }

    @Override
    public List<Country> listDtoToListCountry(List<CountryDto> list_country_dto) {
        if ( list_country_dto == null ) {
            return null;
        }

        List<Country> list = new ArrayList<Country>( list_country_dto.size() );
        for ( CountryDto countryDto : list_country_dto ) {
            list.add( dtoToCountry( countryDto ) );
        }

        return list;
    }

    @Override
    public List<CountryDto> listCountryToListDto(List<Country> list_country) {
        if ( list_country == null ) {
            return null;
        }

        List<CountryDto> list = new ArrayList<CountryDto>( list_country.size() );
        for ( Country country : list_country ) {
            list.add( countryToDto( country ) );
        }

        return list;
    }
}
