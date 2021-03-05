package com.moviesandchill.film.service.service;

import com.moviesandchill.film.service.dto.GenderDto;
import com.moviesandchill.film.service.dto.StaffDto;

import java.util.List;

public interface GenderService {

    List<GenderDto> getAllGender();

    void deleteAllGender();

    GenderDto getGenderById(Long genderId);

    GenderDto addGender(GenderDto genderDto);

    void deleteGenderById(Long genderId);

    List<StaffDto> getAllStaffWithGender(Long genderId);

    void addStaffToGender(Long staffId,Long genderId) throws Exception;
}
