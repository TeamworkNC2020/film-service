package com.moviesandchill.film.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "age_limit")
@Data
public class Age_limit {

    @Id
    @Column(name = "id_age_limit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_age_limit;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "age_limit")
    private List<Film> films = new ArrayList<Film>();


    public Long getId_age_limit() {
        return id_age_limit;
    }

    public void setId_age_limit(Long id_age_limit) {
        this.id_age_limit = id_age_limit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

}
