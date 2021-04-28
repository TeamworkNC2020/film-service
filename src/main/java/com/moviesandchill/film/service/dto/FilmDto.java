package com.moviesandchill.film.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmDto {

    private Long idFilm;

    private String filmTitle;

    private LocalDateTime duration;

    private LocalDate releaseDate;

    private String filmPoster;

    private String filmTrailer;

    private String filmVideo;

    private BigInteger filmBudget;

    private String description;

    private Double rating;
}
