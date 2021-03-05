package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.UserHasReview;
import com.moviesandchill.film.service.dto.UserHasReviewDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserHasReviewMapper {

    UserHasReview dtoToUserHasReview(UserHasReviewDto userHasReviewDto);

    UserHasReviewDto userHasReviewToDto(UserHasReview userHasReview);

    List<UserHasReview> listDtoToListUserHasReview(List<UserHasReviewDto> listUserHasReviewDto);

    List<UserHasReviewDto> listUserHasReviewToListDto(List<UserHasReview> listUserHasReview);
}
