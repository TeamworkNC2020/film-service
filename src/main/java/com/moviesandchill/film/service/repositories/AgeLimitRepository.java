package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.AgeLimit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeLimitRepository extends JpaRepository<AgeLimit, Long> {
}
