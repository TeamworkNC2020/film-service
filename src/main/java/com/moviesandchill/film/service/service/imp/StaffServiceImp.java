package com.moviesandchill.film.service.service.imp;

import com.moviesandchill.film.service.domain.Film;
import com.moviesandchill.film.service.domain.Staff;
import com.moviesandchill.film.service.domain.StaffRole;
import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.dto.StaffDto;
import com.moviesandchill.film.service.dto.StaffRoleDto;
import com.moviesandchill.film.service.mapper.*;
import com.moviesandchill.film.service.repositories.*;
import com.moviesandchill.film.service.service.StaffService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StaffServiceImp implements StaffService {

    @Autowired
    FilmRepository filmRepository;
    StaffRepository staffRepository;
    StaffRoleRepository staffRoleRepository;
    private final FilmMapper filmMapper = Mappers.getMapper(FilmMapper.class);
    private final StaffMapper staffMapper = Mappers.getMapper(StaffMapper.class);
    private final StaffRoleMapper staffRoleMapper = Mappers.getMapper(StaffRoleMapper.class);

    @Override
    public List<StaffDto> getAllStaff() {
        List<Staff> staffs = staffRepository.findAll();
        return staffMapper.listStaffToListDto(staffs);
    }

    @Override
    public void deleteAllStaff() {
        staffRepository.deleteAll();
    }

    @Override
    public StaffDto getStaffById(Long staffId) {
        Optional<Staff> staff = staffRepository.findById(staffId);
        return staff.map(staffMapper::staffToDto).orElse(null);
    }

    @Override
    public StaffDto addStaff(StaffDto staffDto) {
        Staff staff = staffMapper.dtoToStaff(staffDto);
        staff = staffRepository.save(staff);
        return staffMapper.staffToDto(staff);
    }

    @Override
    public void deleteStaffById(Long staffId) {
        staffRepository.deleteById(staffId);
    }

    @Override
    public Set<StaffRoleDto> getAllStaffRoleWithStaff(Long staffId) {
        Optional<Staff> staff = staffRepository.findById(staffId);
        if (staff.isPresent()) {
            Set<StaffRole> staffRoles = new HashSet<>(staff.get().getStaff_roles());
            return staffRoleMapper.setStaffRoleToSetDto(staffRoles);
        }
        return null;
    }

    @Override
    public void addStaffRoleToStaff(Long staffId, Long staffRoleId) throws Exception {
        Staff staff = staffRepository.findById(staffId).orElseThrow(() -> new Exception());
        StaffRole staffRole = staffRoleRepository.findById(staffRoleId).orElseThrow(() -> new Exception());
        staff.getStaff_roles().add(staffRole);
        staffRepository.save(staff);
        staffRole.getStaffs().add(staff);
        staffRoleRepository.save(staffRole);
    }

    @Override
    public Set<FilmDto> getAllFilmWithStaff(Long staffId) {
        Optional<Staff> staff = staffRepository.findById(staffId);
        if (staff.isPresent()) {
            Set<Film> films = new HashSet<>(staff.get().getFilms());
            return filmMapper.setFilmToSetDto(films);
        }
        return null;
    }

    @Override
    public void addFilmToStaff(Long staffId, Long filmId) throws Exception {
        Staff staff = staffRepository.findById(staffId).orElseThrow(() -> new Exception());
        Film film = filmRepository.findById(filmId).orElseThrow(() -> new Exception());
        staff.getFilms().add(film);
        staffRepository.save(staff);
        film.getStaffs().add(staff);
        filmRepository.save(film);
    }
}
