package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
