package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.User_has_review;
import com.moviesandchill.film.service.dto.UserHasReviewDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserHasReviewMapper {

    User_has_review dtoToUserHasReview(UserHasReviewDto user_has_review_dto);

    UserHasReviewDto userHasReviewToDto(User_has_review user_has_review);
}
