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
}
