package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.StaffRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRoleRepository extends JpaRepository<StaffRole, Long> {

    Optional<StaffRole> findByRoleTitle(String role_title);
}
