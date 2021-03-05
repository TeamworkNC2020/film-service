package com.moviesandchill.film.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gender")
@Data
public class Gender {

    @Id
    @Column(name = "id_gender")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_gender;

    @Column(name = "gender_title")
    private String gender_title;

    @OneToMany(mappedBy = "gender")
    private List<Staff> staffs = new ArrayList<Staff>();

    public Long getId_gender() {
        return id_gender;
    }

    public void setId_gender(Long id_gender) {
        this.id_gender = id_gender;
    }

    public String getGender_title() {
        return gender_title;
    }

    public void setGender_title(String gender_title) {
        this.gender_title = gender_title;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }
}
