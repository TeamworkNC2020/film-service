package com.moviesandchill.film.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "film")
@Data
public class Film {

    @Id
    @Column(name = "id_film")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_film;

    @Column(name = "film_title")
    private String film_title;

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "release_date")
    private LocalDate release_date;

    @Column(name = "film_poster")
    private String film_poster;

    @Column(name = "film_trailer")
    private String film_trailer;

    @Column(name = "film_video")
    private String film_video;

    @Column(name = "film_budget")
    private BigInteger film_budget;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_age_limit")
    private Age_limit age_limit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_country")
    private Country country;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_has_genre", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id_genre"))
    private Set<Genre> genres = new HashSet();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_has_staff", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "staff_id", referencedColumnName = "id_staff"))
    private Set<Staff> staffs = new HashSet();

    @OneToMany(mappedBy = "film")
    private List<View_history> view_histories = new ArrayList<View_history>();

    @OneToMany(mappedBy = "film")
    private List<Review> reviews = new ArrayList<Review>();

    public Long getId_film() {
        return id_film;
    }

    public void setId_film(Long id_film) {
        this.id_film = id_film;
    }

    public String getFilm_title() {
        return film_title;
    }

    public void setFilm_title(String film_title) {
        this.film_title = film_title;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public String getFilm_poster() {
        return film_poster;
    }

    public void setFilm_poster(String film_poster) {
        this.film_poster = film_poster;
    }

    public String getFilm_trailer() {
        return film_trailer;
    }

    public void setFilm_trailer(String film_trailer) {
        this.film_trailer = film_trailer;
    }

    public String getFilm_video() {
        return film_video;
    }

    public void setFilm_video(String film_video) {
        this.film_video = film_video;
    }

    public BigInteger getFilm_budget() {
        return film_budget;
    }

    public void setFilm_budget(BigInteger film_budget) {
        this.film_budget = film_budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Age_limit getAge_limit() {
        return age_limit;
    }

    public void setAge_limit(Age_limit age_limit) {
        this.age_limit = age_limit;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<View_history> getView_histories() {
        return view_histories;
    }

    public void setView_histories(List<View_history> view_histories) {
        this.view_histories = view_histories;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
