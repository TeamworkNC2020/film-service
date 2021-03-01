package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
