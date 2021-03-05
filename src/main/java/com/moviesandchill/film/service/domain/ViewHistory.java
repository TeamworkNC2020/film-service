package com.moviesandchill.film.service.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "view_history")
@Data
public class ViewHistory {

    @Id
    @Column(name = "id_view_history")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_view_history;

    @Column(name = "time_movie_watching")
    private Date time_movie_watching;

    @Column(name = "id_user")
    private Long id_user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_film")
    private Film film;

    public Long getId_view_history() {
        return id_view_history;
    }

    public void setId_view_history(Long id_view_history) {
        this.id_view_history = id_view_history;
    }

    public Date getTime_movie_watching() {
        return time_movie_watching;
    }

    public void setTime_movie_watching(Date time_movie_watching) {
        this.time_movie_watching = time_movie_watching;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
