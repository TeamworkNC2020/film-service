package com.moviesandchill.film.service.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "film")
@Data
public class Screenshot {

    @Id
    @Column(name = "id_screenshot")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_screenshot;

    @Column(name = "screenshot")
    private String screenshot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_film")
    private Film film;
}
