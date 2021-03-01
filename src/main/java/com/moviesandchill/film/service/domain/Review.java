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
    @Column(name = "id_review")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_review;

    @Column(name = "rating_film")
    private Float rating_film;

    @Column(name = "review")
    private String review;

    @Column(name = "review_date")
    private LocalDate review_date;

    @Column(name = "id_user")
    private Long id_user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_film")
    private Film film;

    @OneToMany(mappedBy = "review")
    private List<User_has_review> reviews = new ArrayList<User_has_review>();
}
