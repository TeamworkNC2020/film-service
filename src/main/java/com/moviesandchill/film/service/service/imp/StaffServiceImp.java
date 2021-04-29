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

import java.util.*;

@Service
public class StaffServiceImp implements StaffService {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    StaffRoleRepository staffRoleRepository;
    @Autowired
    FilmMapper filmMapper;
    @Autowired
    StaffMapper staffMapper;
    @Autowired
    StaffRoleMapper staffRoleMapper;

    @Override
    public List<StaffDto> getAllStaff() {
        List<Staff> staffs = staffRepository.findAll();
        return staffMapper.listStaffToListDto(staffs);
    }

    @Override
    public List<StaffDto> getAllActorsStaff() {
        Optional<StaffRole> staffRole = staffRoleRepository.findByRoleTitle("Актер");
        if(staffRole.isPresent()){
            List<Staff> actors = staffRepository.findStaffByRole(staffRole.get().getId_staff_role());
            return staffMapper.listStaffToListDto(actors);
        }
        return null;
    }

    @Override
    public List<StaffDto> getAllProducersStaff() {
        Optional<StaffRole> staffRole = staffRoleRepository.findByRoleTitle("Режиссер");
        if(staffRole.isPresent()){
            List<Staff> actors = staffRepository.findStaffByRole(staffRole.get().getId_staff_role());
            return staffMapper.listStaffToListDto(actors);
        }
        return null;
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
    public List<FilmDto> getAllFilmWithStaff(Long staffId) {
        Optional<Staff> staff = staffRepository.findById(staffId);
        if (staff.isPresent()) {
            List<Film> films = new ArrayList<>(staff.get().getFilms());
            return filmMapper.listFilmToListDto(films);
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
