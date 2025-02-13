package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Staff;
import com.moviesandchill.film.service.dto.StaffDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface StaffMapper {

    Staff dtoToStaff(StaffDto staff_dto);

    StaffDto staffToDto(Staff staff);

    List<Staff> listDtoToListStaff(List<StaffDto> list_staff_dto);

    List<StaffDto> listStaffToListDto(List<Staff> list_staff);

    Set<Staff> setDtoToSetStaff(Set<StaffDto> set_staff_dto);

    Set<StaffDto> setStaffToSetDto(Set<Staff> set_staff);
}
