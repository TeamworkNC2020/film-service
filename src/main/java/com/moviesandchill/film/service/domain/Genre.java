package com.moviesandchill.film.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "genre")
@Data
public class Genre {

    @Id
    @Column(name = "id_genre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_genre;

    @Column(name = "genre_title")
    private String genre_title;

    @ManyToMany(mappedBy = "genres")
    private List<Film> films;

    public Long getId_genre() {
        return id_genre;
    }

    public void setId_genre(Long id_genre) {
        this.id_genre = id_genre;
    }

    public String getGenre_title() {
        return genre_title;
    }

    public void setGenre_title(String genre_title) {
        this.genre_title = genre_title;
    }

}
