package com.moviesandchill.film.service.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AgeLimitDto {

    private Long id_age_limit;

    private String title;
}
