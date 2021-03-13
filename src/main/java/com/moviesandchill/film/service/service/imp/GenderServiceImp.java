package com.moviesandchill.film.service.service.imp;

import com.moviesandchill.film.service.domain.Gender;
import com.moviesandchill.film.service.domain.Staff;
import com.moviesandchill.film.service.dto.GenderDto;
import com.moviesandchill.film.service.dto.StaffDto;
import com.moviesandchill.film.service.mapper.FilmMapper;
import com.moviesandchill.film.service.mapper.GenderMapper;
import com.moviesandchill.film.service.mapper.StaffMapper;
import com.moviesandchill.film.service.repositories.GenderRepository;
import com.moviesandchill.film.service.repositories.StaffRepository;
import com.moviesandchill.film.service.service.GenderService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GenderServiceImp implements GenderService {

    @Autowired
    GenderRepository genderRepository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    GenderMapper genderMapper;
    @Autowired
    StaffMapper staffMapper;

    @Override
    public List<GenderDto> getAllGender() {
        List<Gender> genders = genderRepository.findAll();
        return genderMapper.listGenderToListDto(genders);
    }

    @Override
    public void deleteAllGender() {
        genderRepository.deleteAll();
    }

    @Override
    public GenderDto getGenderById(Long genderId) {
        Optional<Gender> gender = genderRepository.findById(genderId);
        return gender.map(genderMapper::genderToDto).orElse(null);
    }

    @Override
    public GenderDto addGender(GenderDto genderDto) {
        Gender gender = genderMapper.dtoToGender(genderDto);
        gender = genderRepository.save(gender);
        return genderMapper.genderToDto(gender);
    }

    @Override
    public void deleteGenderById(Long genderId) {
        genderRepository.deleteById(genderId);
    }

    @Override
    public List<StaffDto> getAllStaffWithGender(Long genderId) {
        Optional<Gender> gender = genderRepository.findById(genderId);
        if (gender.isPresent()) {
            List<Staff> staffs = new ArrayList<>(gender.get().getStaffs());
            return staffMapper.listStaffToListDto(staffs);
        }
        return null;
    }

    @Override
    public void addStaffToGender(Long staffId, Long genderId) throws Exception {
        Gender gender = genderRepository.findById(genderId).orElseThrow(() -> new Exception());
        Staff staff = staffRepository.findById(staffId).orElseThrow(() -> new Exception());
        gender.getStaffs().add(staff);
        genderRepository.save(gender);
    }
}
