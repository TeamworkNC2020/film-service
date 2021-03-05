package com.moviesandchill.film.service.service;

import com.moviesandchill.film.service.dto.UserHasReviewDto;

import java.util.List;

public interface UserHasReviewService {

    List<UserHasReviewDto> getAllUserHasReview();

    void deleteAllUserHasReview();

    UserHasReviewDto getUserHasReviewById(Long userHasReviewId);

    UserHasReviewDto addUserHasReview(UserHasReviewDto userHasReviewDto);

    void deleteUserHasReviewById(Long userHasReviewId);
}
