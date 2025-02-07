package com.moviesandchill.film.service.controller;

import com.moviesandchill.film.service.dto.FilmPageDto;
import com.moviesandchill.film.service.dto.Filter;
import com.moviesandchill.film.service.service.imp.EsService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
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
    public void loadFilmToSearch() throws Exception {
       esService.loadIndexFilm();
    }

    @PostMapping("/search")
    public List<FilmPageDto> search(@RequestParam("search") String search,@RequestBody Filter filter) throws IOException {
        return esService.search(search,filter);
    }
}
