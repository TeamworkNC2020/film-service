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
    private List<UserHasReview> reviews = new ArrayList<UserHasReview>();

    public Long getId_review() {
        return id_review;
    }

    public void setId_review(Long id_review) {
        this.id_review = id_review;
    }

    public Float getRating_film() {
        return rating_film;
    }

    public void setRating_film(Float rating_film) {
        this.rating_film = rating_film;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public LocalDate getReview_date() {
        return review_date;
    }

    public void setReview_date(LocalDate review_date) {
        this.review_date = review_date;
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

    public List<UserHasReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<UserHasReview> reviews) {
        this.reviews = reviews;
    }
}
