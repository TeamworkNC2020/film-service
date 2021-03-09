package com.moviesandchill.film.service.controller;

import com.moviesandchill.film.service.dto.StaffDto;
import com.moviesandchill.film.service.dto.StaffRoleDto;
import com.moviesandchill.film.service.service.StaffRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping(
        path = "/staffRoles",
        produces = "application/json"
)
public class StaffRoleController {

    private final StaffRoleService staffRoleService;

    public StaffRoleController(StaffRoleService staffRoleService) {
        this.staffRoleService = staffRoleService;
    }

    @GetMapping
    public List<StaffRoleDto> getAllStaffRole() {
        return staffRoleService.getAllStaffRole();
    }

    @DeleteMapping
    public void deleteAllStaffRole() {
        staffRoleService.deleteAllStaffRole();
    }

    @GetMapping("/{staffRoleId}")
    public StaffRoleDto getStaffRoleById(@PathVariable Long staffRoleId) {
        return staffRoleService.getStaffRoleById(staffRoleId);
    }

    @PostMapping
    public StaffRoleDto addStaffRole(@RequestBody StaffRoleDto staffRoleDto) {
        return staffRoleService.addStaffRole(staffRoleDto);
    }

    @DeleteMapping("/{staffRoleId}")
    public void deleteStaffRoleById(@PathVariable Long staffRoleId) {
        staffRoleService.deleteStaffRoleById(staffRoleId);
    }

    @GetMapping("/{staffRoleId}/staffs")
    public Set<StaffDto> getAllStaffWithStaffRole(@PathVariable Long staffRoleId) {
        return staffRoleService.getAllStaffWithStaffRole(staffRoleId);
    }

    @PostMapping("/{staffRoleId}/addStaff/{staffId}")
    public void addStaffToStaffRole(Long staffRoleId,Long staffId) throws Exception {
        staffRoleService.addStaffToStaffRole(staffId,staffRoleId);
    }
}
