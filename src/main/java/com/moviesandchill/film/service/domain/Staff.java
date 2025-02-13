package com.moviesandchill.film.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "staff")
@Data
public class Staff {

    @Id
    @Column(name = "id_staff")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_staff;

    @Column(name = "staff_first_name")
    private String staff_first_name;

    @Column(name = "staff_last_name")
    private String staff_last_name;

    @Column(name = "birthday_date")
    private LocalDate birthday_date;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_country")
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_gender")
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_staff_role")
    private StaffRole staff_role;

    @ManyToMany(mappedBy = "staffs")
    private List<Film> films = new ArrayList<>();

    public Long getId_staff() {
        return id_staff;
    }

    public void setId_staff(Long id_staff) {
        this.id_staff = id_staff;
    }

    public String getStaff_first_name() {
        return staff_first_name;
    }

    public void setStaff_first_name(String staff_first_name) {
        this.staff_first_name = staff_first_name;
    }

    public String getStaff_last_name() {
        return staff_last_name;
    }

    public void setStaff_last_name(String staff_last_name) {
        this.staff_last_name = staff_last_name;
    }

    public LocalDate getBirthday_date() {
        return birthday_date;
    }

    public void setBirthday_date(LocalDate birthday_date) {
        this.birthday_date = birthday_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
