package com.moviesandchill.film.service.service;

import com.moviesandchill.film.service.dto.StaffDto;
import com.moviesandchill.film.service.dto.StaffRoleDto;

import java.util.List;
import java.util.Set;

public interface StaffRoleService {

    List<StaffRoleDto> getAllStaffRole();

    void deleteAllStaffRole();

    StaffRoleDto getStaffRoleById(Long staffRoleId);

    StaffRoleDto addStaffRole(StaffRoleDto staffRoleDto);

    void deleteStaffRoleById(Long staffRoleId);

    Set<StaffDto> getAllStaffWithStaffRole(Long staffRoleId);

    void addStaffToStaffRole(Long staffId,Long staffRoleId) throws Exception;
}
