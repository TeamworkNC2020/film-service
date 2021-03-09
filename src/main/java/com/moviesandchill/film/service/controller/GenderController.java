package com.moviesandchill.film.service.controller;

import com.moviesandchill.film.service.dto.GenderDto;
import com.moviesandchill.film.service.dto.StaffDto;
import com.moviesandchill.film.service.service.GenderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(
        path = "/genders",
        produces = "application/json"
)
public class GenderController {

    private final GenderService genderService;

    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping
    public List<GenderDto> getAllGender() {
        return genderService.getAllGender();
    }

    @DeleteMapping
    public void deleteAllGender() {
        genderService.deleteAllGender();
    }

    @GetMapping("/{genderId}")
    public GenderDto getGenderById(@PathVariable Long genderId) {
        return genderService.getGenderById(genderId);
    }

    @PostMapping
    public GenderDto addGender(@RequestBody GenderDto genderDto) {
        return genderService.addGender(genderDto);
    }

    @DeleteMapping("/{genderId}")
    public void deleteGenderById(@PathVariable Long genderId) {
        genderService.deleteGenderById(genderId);
    }

    @GetMapping("/{genderId}/staffs")
    public List<StaffDto> getAllStaffWithGender(@PathVariable Long genderId) {
        return genderService.getAllStaffWithGender(genderId);
    }

    @PostMapping("/{genderId}/addStaff/{staffId}")
    public void addStaffToGender(@PathVariable Long genderId, @PathVariable Long staffId) throws Exception {
        genderService.addStaffToGender(staffId,genderId);
    }
}
