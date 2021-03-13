package com.moviesandchill.film.service.service.imp;

import com.moviesandchill.film.service.domain.Staff;
import com.moviesandchill.film.service.domain.StaffRole;
import com.moviesandchill.film.service.dto.StaffDto;
import com.moviesandchill.film.service.dto.StaffRoleDto;
import com.moviesandchill.film.service.mapper.ReviewMapper;
import com.moviesandchill.film.service.mapper.StaffMapper;
import com.moviesandchill.film.service.mapper.StaffRoleMapper;
import com.moviesandchill.film.service.repositories.StaffRepository;
import com.moviesandchill.film.service.repositories.StaffRoleRepository;
import com.moviesandchill.film.service.service.StaffRoleService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StaffRoleServiceImp implements StaffRoleService {

    @Autowired
    StaffRepository staffRepository;
    @Autowired
    StaffRoleRepository staffRoleRepository;
    @Autowired
    StaffMapper staffMapper;
    @Autowired
    StaffRoleMapper staffRoleMapper;

    @Override
    public List<StaffRoleDto> getAllStaffRole() {
        List<StaffRole> staffRoles = staffRoleRepository.findAll();
        return staffRoleMapper.listStaffRoleToListDto(staffRoles);
    }

    @Override
    public void deleteAllStaffRole() {
        staffRoleRepository.deleteAll();
    }

    @Override
    public StaffRoleDto getStaffRoleById(Long staffRoleId) {
        Optional<StaffRole> staffRole = staffRoleRepository.findById(staffRoleId);
        return staffRole.map(staffRoleMapper::staffRoleToDto).orElse(null);
    }

    @Override
    public StaffRoleDto addStaffRole(StaffRoleDto staffRoleDto) {
        StaffRole staffRole = staffRoleMapper.dtoToStaffRole(staffRoleDto);
        staffRole = staffRoleRepository.save(staffRole);
        return staffRoleMapper.staffRoleToDto(staffRole);
    }

    @Override
    public void deleteStaffRoleById(Long staffRoleId) {
        staffRoleRepository.deleteById(staffRoleId);
    }

    @Override
    public List<StaffDto> getAllStaffWithStaffRole(Long staffRoleId) {
        Optional<StaffRole> staffRole = staffRoleRepository.findById(staffRoleId);
        if (staffRole.isPresent()) {
            List<Staff> staffs = new ArrayList<>(staffRole.get().getStaffs());
            return staffMapper.listStaffToListDto(staffs);
        }
        return null;
    }

    @Override
    public void addStaffToStaffRole(Long staffId, Long staffRoleId) throws Exception {
        StaffRole staffRole = staffRoleRepository.findById(staffRoleId).orElseThrow(() -> new Exception());
        Staff staff = staffRepository.findById(staffId).orElseThrow(() -> new Exception());
        staffRole.getStaffs().add(staff);
        staffRoleRepository.save(staffRole);
    }
}
