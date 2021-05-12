package com.moviesandchill.film.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "film")
@Data
public class Film {

    @Id
    @Column(name = "idFilm")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilm;

    @Column(name = "filmTitle")
    private String filmTitle;

    @Column(name = "duration")
    private LocalDateTime duration;

    @Column(name = "releaseDate")
    private LocalDate releaseDate;

    @Column(name = "filmPoster")
    private String filmPoster;

    @Column(name = "filmTrailer")
    private String filmTrailer;

    @Column(name = "filmVideo")
    private String filmVideo;

    @Column(name = "filmBudget")
    private BigInteger filmBudget;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_age_limit")
    private AgeLimit age_limit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_country")
    private Country country;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_has_genre", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "idFilm"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id_genre"))
    private List<Genre> genres = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_has_staff", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "idFilm"),
            inverseJoinColumns = @JoinColumn(name = "staff_id", referencedColumnName = "id_staff"))
    private List<Staff> staffs = new ArrayList<>();

    @OneToMany(mappedBy = "film")
    private List<ViewHistory> view_histories = new ArrayList<ViewHistory>();

    @OneToMany(mappedBy = "film")
    private List<Review> reviews = new ArrayList<Review>();

    @OneToMany(mappedBy = "film")
    private List<Screenshot> screenshots = new ArrayList<Screenshot>();

}
