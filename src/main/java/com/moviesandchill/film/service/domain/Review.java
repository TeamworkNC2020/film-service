package com.moviesandchill.film.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "review")
@Data
public class Review {

    @Id
    @Column(name = "idReview")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReview;

    @Column(name = "ratingFilm")
    private Float ratingFilm;

    @Column(name = "review")
    private String review;

    @Column(name = "reviewDate")
    private LocalDate reviewDate;

    @Column(name = "idUser")
    private Long idUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_film")
    private Film film;

    @OneToMany(mappedBy = "review")
    private List<UserHasReview> reviews = new ArrayList<UserHasReview>();


}
