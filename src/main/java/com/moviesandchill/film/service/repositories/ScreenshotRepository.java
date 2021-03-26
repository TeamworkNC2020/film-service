package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.Screenshot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenshotRepository extends JpaRepository<Screenshot, Long> {
}
