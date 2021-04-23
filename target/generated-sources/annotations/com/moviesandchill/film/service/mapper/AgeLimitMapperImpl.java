package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.AgeLimit;
import com.moviesandchill.film.service.dto.AgeLimitDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-23T16:39:48+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class AgeLimitMapperImpl implements AgeLimitMapper {

    @Override
    public AgeLimit dtoToAgeLimit(AgeLimitDto age_limit_dto) {
        if ( age_limit_dto == null ) {
            return null;
        }

        AgeLimit ageLimit = new AgeLimit();

        if ( age_limit_dto.getId_age_limit() != null ) {
            ageLimit.setId_age_limit( age_limit_dto.getId_age_limit() );
        }
        if ( age_limit_dto.getTitle() != null ) {
            ageLimit.setTitle( age_limit_dto.getTitle() );
        }

        return ageLimit;
    }

    @Override
    public AgeLimitDto ageLimitToDto(AgeLimit age_limit) {
        if ( age_limit == null ) {
            return null;
        }

        AgeLimitDto ageLimitDto = new AgeLimitDto();

        if ( age_limit.getId_age_limit() != null ) {
            ageLimitDto.setId_age_limit( age_limit.getId_age_limit() );
        }
        if ( age_limit.getTitle() != null ) {
            ageLimitDto.setTitle( age_limit.getTitle() );
        }

        return ageLimitDto;
    }

    @Override
    public List<AgeLimit> listDtoToListAgeLimit(List<AgeLimitDto> list_age_limit_dto) {
        if ( list_age_limit_dto == null ) {
            return null;
        }

        List<AgeLimit> list = new ArrayList<AgeLimit>( list_age_limit_dto.size() );
        for ( AgeLimitDto ageLimitDto : list_age_limit_dto ) {
            list.add( dtoToAgeLimit( ageLimitDto ) );
        }

        return list;
    }

    @Override
    public List<AgeLimitDto> listAgeLimitToListDto(List<AgeLimit> list_age_limit) {
        if ( list_age_limit == null ) {
            return null;
        }

        List<AgeLimitDto> list = new ArrayList<AgeLimitDto>( list_age_limit.size() );
        for ( AgeLimit ageLimit : list_age_limit ) {
            list.add( ageLimitToDto( ageLimit ) );
        }

        return list;
    }
}
