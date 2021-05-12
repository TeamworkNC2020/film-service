package com.moviesandchill.film.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchFilm {

    private Long idFilm;

    private String filmTitle;

    private LocalDateTime duration;

    private LocalDate releaseDate;

    private String filmPoster;

    private String filmTrailer;

    private String filmVideo;

    private BigInteger filmBudget;

    private String description;

    private Long idages;

    private List<Long> idgenres = new ArrayList<>();

    private List<Long> idproducers = new ArrayList<>();
}
