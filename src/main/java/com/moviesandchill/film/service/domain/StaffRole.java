package com.moviesandchill.film.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "staff_role")
@Data
public class StaffRole {

    @Id
    @Column(name = "id_staff_role")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_staff_role;

    @Column(name = "roleTitle")
    private String roleTitle;

    @OneToMany(mappedBy = "staff_role")
    private List<Staff> staffs = new ArrayList<>();

    public Long getId_staff_role() {
        return id_staff_role;
    }

    public void setId_staff_role(Long id_staff_role) {
        this.id_staff_role = id_staff_role;
    }


}
