package com.moviesandchill.film.service.service;

import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.dto.StaffDto;
import com.moviesandchill.film.service.dto.StaffRoleDto;

import java.util.List;
import java.util.Set;

public interface StaffService {

    List<StaffDto> getAllStaff();

    void deleteAllStaff();

    StaffDto getStaffById(Long staffId);

    StaffDto addStaff(StaffDto staffDto);

    void deleteStaffById(Long staffId);

    Set<StaffRoleDto> getAllStaffRoleWithStaff(Long staffId);

    void addStaffRoleToStaff(Long StaffId,Long staffRoleId) throws Exception;

    Set<FilmDto> getAllFilmWithStaff(Long staffId);

    void addFilmToStaff(Long staffId,Long filmId) throws Exception;
}
