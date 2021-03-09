package com.moviesandchill.film.service.controller;

import com.moviesandchill.film.service.dto.UserHasReviewDto;
import com.moviesandchill.film.service.service.UserHasReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(
        path = "/userHasReviews",
        produces = "application/json"
)
public class UserHasReviewController {

    private final UserHasReviewService userHasReviewService;

    public UserHasReviewController(UserHasReviewService userHasReviewService) {
        this.userHasReviewService = userHasReviewService;
    }

    @GetMapping
    public List<UserHasReviewDto> getAllUserHasReview() {
        return userHasReviewService.getAllUserHasReview();
    }

    @DeleteMapping
    public void deleteAllUserHasReview() {
        userHasReviewService.deleteAllUserHasReview();
    }

    @GetMapping("/{userHasReviewId}")
    public UserHasReviewDto getUserHasReviewById(@PathVariable Long userHasReviewId) {
        return userHasReviewService.getUserHasReviewById(userHasReviewId);
    }

    @PostMapping
    public UserHasReviewDto addUserHasReview(@RequestBody UserHasReviewDto userHasReviewDto) {
        return userHasReviewService.addUserHasReview(userHasReviewDto);
    }

    @DeleteMapping("/{userHasReviewId}")
    public void deleteUserHasReviewById(@PathVariable Long userHasReviewId) {
        userHasReviewService.deleteUserHasReviewById(userHasReviewId);
    }
}
