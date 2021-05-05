package com.moviesandchill.film.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {

    private Long idReview;

    private Float ratingFilm;

    private String review;

    private LocalDate reviewDate;

    private Long idUser;

    private Long idFilm;
}
