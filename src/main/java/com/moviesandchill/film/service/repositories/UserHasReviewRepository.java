package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.UserHasReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHasReviewRepository extends JpaRepository<UserHasReview, Long> {
}
