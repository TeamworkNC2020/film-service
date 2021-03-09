package com.moviesandchill.film.service.controller;

import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.dto.StaffDto;
import com.moviesandchill.film.service.dto.StaffRoleDto;
import com.moviesandchill.film.service.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping(
        path = "/staffs",
        produces = "application/json"
)
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<StaffDto> getAllStaff() {
        return staffService.getAllStaff();
    }

    @DeleteMapping
    public void deleteAllStaff() {
        staffService.deleteAllStaff();
    }

    @GetMapping("/{staffId}")
    public StaffDto getStaffById(@PathVariable Long staffId) {
        return staffService.getStaffById(staffId);
    }

    @PostMapping
    public StaffDto addStaff(@RequestBody StaffDto staffDto) {
        return staffService.addStaff(staffDto);
    }

    @DeleteMapping("/{staffId}")
    public void deleteStaffById(@PathVariable Long staffId) {
        staffService.deleteStaffById(staffId);
    }

    @GetMapping("/{staffId}/staffRoles")
    public Set<StaffRoleDto> getAllStaffRoleWithStaff(@PathVariable Long staffId) {
        return staffService.getAllStaffRoleWithStaff(staffId);
    }

    @PostMapping("/{staffId}/addStaffRole/{staffRoleId}")
    public void addStaffRoleToStaff(@PathVariable Long staffId,@PathVariable Long staffRoleId) throws Exception {
        staffService.addStaffRoleToStaff(staffId,staffRoleId);
    }

    @GetMapping("/{staffId}/films")
    public Set<FilmDto> getAllFilmWithStaff(@PathVariable Long staffId) {
        return staffService.getAllFilmWithStaff(staffId);
    }

    @PostMapping("/{staffId}/addFilm/{filmId}")
    public void addFilmToStaff(@PathVariable Long staffId,@PathVariable Long filmId) throws Exception {
        staffService.addFilmToStaff(staffId,filmId);
    }
}
