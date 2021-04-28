package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Gender;
import com.moviesandchill.film.service.dto.GenderDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-28T23:13:34+0300",
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

        if ( genderDto.getId_gender() != null ) {
            gender.setId_gender( genderDto.getId_gender() );
        }
        if ( genderDto.getGender_title() != null ) {
            gender.setGender_title( genderDto.getGender_title() );
        }

        return gender;
    }

    @Override
    public GenderDto genderToDto(Gender gender) {
        if ( gender == null ) {
            return null;
        }

        GenderDto genderDto = new GenderDto();

        if ( gender.getId_gender() != null ) {
            genderDto.setId_gender( gender.getId_gender() );
        }
        if ( gender.getGender_title() != null ) {
            genderDto.setGender_title( gender.getGender_title() );
        }

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
