package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.UserHasReview;
import com.moviesandchill.film.service.dto.UserHasReviewDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-23T16:39:47+0300",
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

        if ( userHasReviewDto.getId_user_has_review() != null ) {
            userHasReview.setId_user_has_review( userHasReviewDto.getId_user_has_review() );
        }
        if ( userHasReviewDto.getId_user() != null ) {
            userHasReview.setId_user( userHasReviewDto.getId_user() );
        }
        if ( userHasReviewDto.getUser_score() != null ) {
            userHasReview.setUser_score( userHasReviewDto.getUser_score() );
        }

        return userHasReview;
    }

    @Override
    public UserHasReviewDto userHasReviewToDto(UserHasReview userHasReview) {
        if ( userHasReview == null ) {
            return null;
        }

        UserHasReviewDto userHasReviewDto = new UserHasReviewDto();

        if ( userHasReview.getId_user_has_review() != null ) {
            userHasReviewDto.setId_user_has_review( userHasReview.getId_user_has_review() );
        }
        if ( userHasReview.getId_user() != null ) {
            userHasReviewDto.setId_user( userHasReview.getId_user() );
        }
        if ( userHasReview.getUser_score() != null ) {
            userHasReviewDto.setUser_score( userHasReview.getUser_score() );
        }

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
