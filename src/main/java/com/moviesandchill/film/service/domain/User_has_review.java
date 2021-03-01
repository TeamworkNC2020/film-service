package com.moviesandchill.film.service.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_has_review")
@Data
public class User_has_review {

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
}
