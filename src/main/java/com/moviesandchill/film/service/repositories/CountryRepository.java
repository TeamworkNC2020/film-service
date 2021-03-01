package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
