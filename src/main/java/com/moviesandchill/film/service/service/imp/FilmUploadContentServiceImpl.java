package com.moviesandchill.film.service.service.imp;

import com.moviesandchill.film.service.domain.Film;
import com.moviesandchill.film.service.domain.Screenshot;
import com.moviesandchill.film.service.repositories.FilmRepository;
import com.moviesandchill.film.service.repositories.ScreenshotRepository;
import com.moviesandchill.film.service.service.FilmUploadContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilmUploadContentServiceImpl implements FilmUploadContentService {

    FilmRepository filmRepository;
    ScreenshotRepository screenshotRepository;
    private String streamingServiceUrl;

    @Override
    public void uploadFilmPoster(long filmId, MultipartFile file) throws Exception {
        Film film = filmRepository.findById(filmId).orElseThrow(() -> new Exception());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("file", file.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);

        String url = streamingServiceUrl + "video/" + filmId + "/uploadFilmImage";

        String posterUrl = new RestTemplate()
                .postForObject(url, requestEntity, String.class);

        film.setFilmPoster(posterUrl);
        filmRepository.save(film);
    }

    @Override
    public void uploadFilmScreenshot(long filmId, MultipartFile file) throws Exception {
        Film film = filmRepository.findById(filmId).orElseThrow(() -> new Exception());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("file", file.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);

        String url = streamingServiceUrl + "video/" + filmId + "/uploadFilmImage";

        String screenshotUrl = new RestTemplate()
                .postForObject(url, requestEntity, String.class);
        Screenshot screenshot = new Screenshot();
        screenshot.setScreenshot(screenshotUrl);
        screenshot.setFilm(film);
        screenshotRepository.save(screenshot);
    }

    @Override
    public void uploadFilmVideo(long filmId, MultipartFile file) throws Exception {
        Film film = filmRepository.findById(filmId).orElseThrow(() -> new Exception());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("file", file.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);

        String url = streamingServiceUrl + "video/" + filmId + "/uploadVideo";

        String videoUrl = new RestTemplate()
                .postForObject(url, requestEntity, String.class);

        film.setFilmVideo(videoUrl);
        filmRepository.save(film);
    }

    @Autowired
    public void setFilmRepository(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Autowired
    public void setScreenshotRepository(ScreenshotRepository screenshotRepository) {
        this.screenshotRepository = screenshotRepository;
    }

    @Autowired
    public void setStreamingServiceUrl(@Value("${endpoint.streaming-service.url}") String streamingServiceUrl) {
        this.streamingServiceUrl = streamingServiceUrl;
    }
}
