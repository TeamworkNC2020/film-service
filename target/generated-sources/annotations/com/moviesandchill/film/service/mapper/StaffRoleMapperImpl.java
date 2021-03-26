package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.StaffRole;
import com.moviesandchill.film.service.dto.StaffRoleDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-26T16:26:16+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class StaffRoleMapperImpl implements StaffRoleMapper {

    @Override
    public StaffRole dtoToStaffRole(StaffRoleDto staff_role_dto) {
        if ( staff_role_dto == null ) {
            return null;
        }

        StaffRole staffRole = new StaffRole();

        if ( staff_role_dto.getId_staff_role() != null ) {
            staffRole.setId_staff_role( staff_role_dto.getId_staff_role() );
        }
        if ( staff_role_dto.getRole_title() != null ) {
            staffRole.setRole_title( staff_role_dto.getRole_title() );
        }

        return staffRole;
    }

    @Override
    public StaffRoleDto staffRoleToDto(StaffRole staff_role) {
        if ( staff_role == null ) {
            return null;
        }

        StaffRoleDto staffRoleDto = new StaffRoleDto();

        if ( staff_role.getId_staff_role() != null ) {
            staffRoleDto.setId_staff_role( staff_role.getId_staff_role() );
        }
        if ( staff_role.getRole_title() != null ) {
            staffRoleDto.setRole_title( staff_role.getRole_title() );
        }

        return staffRoleDto;
    }

    @Override
    public List<StaffRole> listDtoToListStaffRole(List<StaffRoleDto> listStaffRoleDto) {
        if ( listStaffRoleDto == null ) {
            return null;
        }

        List<StaffRole> list = new ArrayList<StaffRole>( listStaffRoleDto.size() );
        for ( StaffRoleDto staffRoleDto : listStaffRoleDto ) {
            list.add( dtoToStaffRole( staffRoleDto ) );
        }

        return list;
    }

    @Override
    public List<StaffRoleDto> listStaffRoleToListDto(List<StaffRole> listStaffRole) {
        if ( listStaffRole == null ) {
            return null;
        }

        List<StaffRoleDto> list = new ArrayList<StaffRoleDto>( listStaffRole.size() );
        for ( StaffRole staffRole : listStaffRole ) {
            list.add( staffRoleToDto( staffRole ) );
        }

        return list;
    }

    @Override
    public Set<StaffRole> setDtoToSetStaffRole(Set<StaffRoleDto> setStaffRoleDto) {
        if ( setStaffRoleDto == null ) {
            return null;
        }

        Set<StaffRole> set = new HashSet<StaffRole>( Math.max( (int) ( setStaffRoleDto.size() / .75f ) + 1, 16 ) );
        for ( StaffRoleDto staffRoleDto : setStaffRoleDto ) {
            set.add( dtoToStaffRole( staffRoleDto ) );
        }

        return set;
    }

    @Override
    public Set<StaffRoleDto> setStaffRoleToSetDto(Set<StaffRole> setStaffRole) {
        if ( setStaffRole == null ) {
            return null;
        }

        Set<StaffRoleDto> set = new HashSet<StaffRoleDto>( Math.max( (int) ( setStaffRole.size() / .75f ) + 1, 16 ) );
        for ( StaffRole staffRole : setStaffRole ) {
            set.add( staffRoleToDto( staffRole ) );
        }

        return set;
    }
}
