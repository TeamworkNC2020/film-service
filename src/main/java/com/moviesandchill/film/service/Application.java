package com.moviesandchill.film.service;

import com.moviesandchill.film.service.dto.AgeLimitDto;
import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.dto.GenderDto;
import com.moviesandchill.film.service.dto.GenreDto;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EntityScan(basePackages = {"com.moviesandchill.film.service.domain" })
@EnableJpaRepositories(basePackages = {"com.moviesandchill.film.service.repositories"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
   }
}
