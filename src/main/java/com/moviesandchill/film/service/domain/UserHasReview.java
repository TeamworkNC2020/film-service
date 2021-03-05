package com.moviesandchill.film.service.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_has_review")
@Data
public class UserHasReview {

    @Id
    @Column(name = "id_user_has_review")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user_has_review;

    @Column(name = "id_user")
    private Long id_user;

    @Column(name = "user_score")
    private Boolean user_score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_review")
    private Review review;

    public Long getId_user_has_review() {
        return id_user_has_review;
    }

    public void setId_user_has_review(Long id_user_has_review) {
        this.id_user_has_review = id_user_has_review;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Boolean getUser_score() {
        return user_score;
    }

    public void setUser_score(Boolean user_score) {
        this.user_score = user_score;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
