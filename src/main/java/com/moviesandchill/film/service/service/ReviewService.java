package com.moviesandchill.film.service.service;

import com.moviesandchill.film.service.dto.ReviewDto;
import com.moviesandchill.film.service.dto.UserHasReviewDto;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> getAllReview();

    void deleteAllReview();

    ReviewDto getReviewById(Long reviewId);

    ReviewDto addReview(ReviewDto reviewDto);

    void deleteReviewById(Long reviewId);

    List<UserHasReviewDto> getAllUserHasReviewWithReview(Long reviewId);

    void addUserHasReviewToReview(Long reviewId,Long userHasReviewId) throws Exception;
}
