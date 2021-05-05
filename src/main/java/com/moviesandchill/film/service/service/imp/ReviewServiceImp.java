package com.moviesandchill.film.service.service.imp;

import com.moviesandchill.film.service.domain.Review;
import com.moviesandchill.film.service.domain.UserHasReview;
import com.moviesandchill.film.service.dto.ReviewDto;
import com.moviesandchill.film.service.dto.UserHasReviewDto;
import com.moviesandchill.film.service.mapper.*;
import com.moviesandchill.film.service.repositories.*;
import com.moviesandchill.film.service.service.ReviewService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReviewServiceImp implements ReviewService {

    @Autowired
    UserHasReviewRepository userHasReviewRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    UserHasReviewMapper userHasReviewMapper;
    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public List<ReviewDto> getAllReview() {
        List<Review> reviews = reviewRepository.findAll();
        List<ReviewDto> list = new ArrayList<>();
        for(Review review : reviews){
            ReviewDto reviewDto = reviewMapper.reviewToDto(review);
            reviewDto.setIdFilm(review.getFilm().getIdFilm());
            list.add(reviewDto);
        }
        return list;
    }

    @Override
    public void deleteAllReview() {
        reviewRepository.deleteAll();
    }

    @Override
    public ReviewDto getReviewById(Long reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        return review.map(reviewMapper::reviewToDto).orElse(null);
    }

    @Override
    public ReviewDto addReview(ReviewDto reviewDto) {
        Review review = reviewMapper.dtoToReview(reviewDto);
        review = reviewRepository.save(review);
        return reviewMapper.reviewToDto(review);
    }

    @Override
    public void deleteReviewById(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public List<UserHasReviewDto> getAllUserHasReviewWithReview(Long reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if (review.isPresent()) {
            List<UserHasReview> userHasReviews = new ArrayList<>(review.get().getReviews());
            return userHasReviewMapper.listUserHasReviewToListDto(userHasReviews);
        }
        return null;
    }

    @Override
    public void addUserHasReviewToReview(Long reviewId, Long userHasReviewId) throws Exception {
        Review review = reviewRepository.findById(reviewId).orElseThrow(()->new Exception());
        UserHasReview userHasReview = userHasReviewRepository.findById(userHasReviewId).orElseThrow(()->new Exception());
        review.getReviews().add(userHasReview);
        reviewRepository.save(review);
    }
}
