package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Staff;
import com.moviesandchill.film.service.dto.StaffDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-09T17:41:53+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class StaffMapperImpl implements StaffMapper {

    @Override
    public Staff dtoToStaff(StaffDto staff_dto) {
        if ( staff_dto == null ) {
            return null;
        }

        Staff staff = new Staff();

        return staff;
    }

    @Override
    public StaffDto staffToDto(Staff staff) {
        if ( staff == null ) {
            return null;
        }

        StaffDto staffDto = new StaffDto();

        return staffDto;
    }

    @Override
    public List<Staff> listDtoToListStaff(List<StaffDto> list_staff_dto) {
        if ( list_staff_dto == null ) {
            return null;
        }

        List<Staff> list = new ArrayList<Staff>( list_staff_dto.size() );
        for ( StaffDto staffDto : list_staff_dto ) {
            list.add( dtoToStaff( staffDto ) );
        }

        return list;
    }

    @Override
    public List<StaffDto> listStaffToListDto(List<Staff> list_staff) {
        if ( list_staff == null ) {
            return null;
        }

        List<StaffDto> list = new ArrayList<StaffDto>( list_staff.size() );
        for ( Staff staff : list_staff ) {
            list.add( staffToDto( staff ) );
        }

        return list;
    }

    @Override
    public Set<Staff> setDtoToSetStaff(Set<StaffDto> set_staff_dto) {
        if ( set_staff_dto == null ) {
            return null;
        }

        Set<Staff> set = new HashSet<Staff>( Math.max( (int) ( set_staff_dto.size() / .75f ) + 1, 16 ) );
        for ( StaffDto staffDto : set_staff_dto ) {
            set.add( dtoToStaff( staffDto ) );
        }

        return set;
    }

    @Override
    public Set<StaffDto> setStaffToSetDto(Set<Staff> set_staff) {
        if ( set_staff == null ) {
            return null;
        }

        Set<StaffDto> set = new HashSet<StaffDto>( Math.max( (int) ( set_staff.size() / .75f ) + 1, 16 ) );
        for ( Staff staff : set_staff ) {
            set.add( staffToDto( staff ) );
        }

        return set;
    }
}
