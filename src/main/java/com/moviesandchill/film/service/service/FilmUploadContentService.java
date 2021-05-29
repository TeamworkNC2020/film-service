package com.moviesandchill.film.service.service;

import org.springframework.web.multipart.MultipartFile;

public interface FilmUploadContentService {

    void uploadFilmPoster(long filmId, MultipartFile file) throws Exception;

    void uploadFilmScreenshot(long filmId, MultipartFile file) throws Exception;

    void uploadFilmVideo(long filmId, MultipartFile file) throws Exception;

}
