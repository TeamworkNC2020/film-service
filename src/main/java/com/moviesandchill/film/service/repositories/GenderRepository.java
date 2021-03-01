package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}
