package com.moviesandchill.film.service.controller;

import com.moviesandchill.film.service.dto.ReviewDto;
import com.moviesandchill.film.service.dto.UserHasReviewDto;
import com.moviesandchill.film.service.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(
        path = "/reviews",
        produces = "application/json"
)
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDto> getAllReview() {
        return reviewService.getAllReview();
    }

    @DeleteMapping
    public void deleteAllReview() {
        reviewService.deleteAllReview();
    }

    @GetMapping("/{reviewId}")
    public ReviewDto getReviewById(@PathVariable Long reviewId) {
        return reviewService.getReviewById(reviewId);
    }

    @PostMapping
    public ReviewDto addReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.addReview(reviewDto);
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReviewById(@PathVariable Long reviewId) {
        reviewService.deleteReviewById(reviewId);
    }

    @GetMapping("/{reviewId}/userHasReviews")
    public List<UserHasReviewDto> getAllUserHasReviewWithReview(@PathVariable Long reviewId) {
        return reviewService.getAllUserHasReviewWithReview(reviewId);
    }

    @PostMapping("/{reviewId}/addUserHasReview/{userHasReviewId}")
    public void addUserHasReviewToReview(@PathVariable Long reviewId,@PathVariable Long userHasReviewId) throws Exception {
        reviewService.addUserHasReviewToReview(reviewId,userHasReviewId);
    }
}
