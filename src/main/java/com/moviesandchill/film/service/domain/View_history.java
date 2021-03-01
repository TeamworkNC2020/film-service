package com.moviesandchill.film.service.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "view_history")
@Data
public class View_history {

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
}
