package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Query(value = "SELECT s \n" +
            "\tFROM Staff s \n" +
            "\tjoin s.films f \n" +
            "\twhere f.id_film = ?2 and s.staff_role.id_staff_role=?1")
    List<Staff> findStaffByRoleAndFilm(Long roleId,Long filmId);
}
