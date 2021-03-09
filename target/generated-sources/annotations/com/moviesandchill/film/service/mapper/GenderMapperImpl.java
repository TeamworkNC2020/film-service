package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Gender;
import com.moviesandchill.film.service.dto.GenderDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-09T17:41:53+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class GenderMapperImpl implements GenderMapper {

    @Override
    public Gender dtoToGender(GenderDto genderDto) {
        if ( genderDto == null ) {
            return null;
        }

        Gender gender = new Gender();

        return gender;
    }

    @Override
    public GenderDto genderToDto(Gender gender) {
        if ( gender == null ) {
            return null;
        }

        GenderDto genderDto = new GenderDto();

        return genderDto;
    }

    @Override
    public List<Gender> listDtoToListGender(List<GenderDto> listGenderDto) {
        if ( listGenderDto == null ) {
            return null;
        }

        List<Gender> list = new ArrayList<Gender>( listGenderDto.size() );
        for ( GenderDto genderDto : listGenderDto ) {
            list.add( dtoToGender( genderDto ) );
        }

        return list;
    }

    @Override
    public List<GenderDto> listGenderToListDto(List<Gender> listGender) {
        if ( listGender == null ) {
            return null;
        }

        List<GenderDto> list = new ArrayList<GenderDto>( listGender.size() );
        for ( Gender gender : listGender ) {
            list.add( genderToDto( gender ) );
        }

        return list;
    }
}
