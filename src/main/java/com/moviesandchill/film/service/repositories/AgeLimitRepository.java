package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.Age_limit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeLimitRepository extends JpaRepository<Age_limit, Long> {
}
