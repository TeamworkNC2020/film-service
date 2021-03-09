package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.UserHasReview;
import com.moviesandchill.film.service.dto.UserHasReviewDto;
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
public class UserHasReviewMapperImpl implements UserHasReviewMapper {

    @Override
    public UserHasReview dtoToUserHasReview(UserHasReviewDto userHasReviewDto) {
        if ( userHasReviewDto == null ) {
            return null;
        }

        UserHasReview userHasReview = new UserHasReview();

        return userHasReview;
    }

    @Override
    public UserHasReviewDto userHasReviewToDto(UserHasReview userHasReview) {
        if ( userHasReview == null ) {
            return null;
        }

        UserHasReviewDto userHasReviewDto = new UserHasReviewDto();

        return userHasReviewDto;
    }

    @Override
    public List<UserHasReview> listDtoToListUserHasReview(List<UserHasReviewDto> listUserHasReviewDto) {
        if ( listUserHasReviewDto == null ) {
            return null;
        }

        List<UserHasReview> list = new ArrayList<UserHasReview>( listUserHasReviewDto.size() );
        for ( UserHasReviewDto userHasReviewDto : listUserHasReviewDto ) {
            list.add( dtoToUserHasReview( userHasReviewDto ) );
        }

        return list;
    }

    @Override
    public List<UserHasReviewDto> listUserHasReviewToListDto(List<UserHasReview> listUserHasReview) {
        if ( listUserHasReview == null ) {
            return null;
        }

        List<UserHasReviewDto> list = new ArrayList<UserHasReviewDto>( listUserHasReview.size() );
        for ( UserHasReview userHasReview : listUserHasReview ) {
            list.add( userHasReviewToDto( userHasReview ) );
        }

        return list;
    }
}
