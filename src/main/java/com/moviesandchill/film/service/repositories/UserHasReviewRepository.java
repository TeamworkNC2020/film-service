package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.User_has_review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHasReviewRepository extends JpaRepository<User_has_review, Long> {
}
