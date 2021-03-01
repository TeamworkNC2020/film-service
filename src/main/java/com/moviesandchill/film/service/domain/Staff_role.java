package com.moviesandchill.film.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "staff_role")
@Data
public class Staff_role {

    @Id
    @Column(name = "id_staff_role")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_staff_role;

    @Column(name = "role_title")
    private String role_title;

    @ManyToMany(mappedBy = "staff_roles")
    private Set<Staff> staffs = new HashSet();

}
