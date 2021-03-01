package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Staff_role;
import com.moviesandchill.film.service.dto.StaffRoleDto;
import org.mapstruct.Mapper;

@Mapper
public interface StaffRoleMapper {

    Staff_role dtoToStaffRole(StaffRoleDto staff_role_dto);

    StaffRoleDto staffRoleToDto(Staff_role staff_role);
}
