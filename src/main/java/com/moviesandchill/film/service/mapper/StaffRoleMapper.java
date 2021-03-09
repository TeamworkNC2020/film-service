package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.StaffRole;
import com.moviesandchill.film.service.dto.StaffRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface StaffRoleMapper {

    StaffRole dtoToStaffRole(StaffRoleDto staff_role_dto);

    StaffRoleDto staffRoleToDto(StaffRole staff_role);

    List<StaffRole> listDtoToListStaffRole(List<StaffRoleDto> listStaffRoleDto);

    List<StaffRoleDto> listStaffRoleToListDto(List<StaffRole> listStaffRole);

    Set<StaffRole> setDtoToSetStaffRole(Set<StaffRoleDto> setStaffRoleDto);

    Set<StaffRoleDto> setStaffRoleToSetDto(Set<StaffRole> setStaffRole);
}
