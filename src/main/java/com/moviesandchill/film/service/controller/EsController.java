package com.moviesandchill.film.service.controller;

import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.service.imp.EsService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(
        path = "/es",
        produces = "application/json"
)
public class EsController {

    private EsService esService;

    public EsController(EsService esService) {
        this.esService = esService;
    }

    @PutMapping("/reload")
    public void loadFilmToSearch() throws IOException {
        esService.updateIndexFilm();
    }

    @GetMapping("/search")
    public List<FilmDto> search(@RequestParam("search") String searchString) throws IOException {
        return esService.search(searchString);
    }
}
