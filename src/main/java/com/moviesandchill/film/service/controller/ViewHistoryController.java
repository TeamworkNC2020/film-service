package com.moviesandchill.film.service.controller;

import com.moviesandchill.film.service.dto.AgeLimitDto;
import com.moviesandchill.film.service.dto.ViewHistoryDto;
import com.moviesandchill.film.service.service.ViewHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(
        path = "/viewHistories",
        produces = "application/json"
)
public class ViewHistoryController {

    private final ViewHistoryService viewHistoryService;

    public ViewHistoryController(ViewHistoryService viewHistoryService) {
        this.viewHistoryService = viewHistoryService;
    }

    @GetMapping
    public List<ViewHistoryDto> getAllViewHistory() {
        return viewHistoryService.getAllViewHistory();
    }

    @DeleteMapping
    public void deleteAllViewHistory() {
        viewHistoryService.deleteAllViewHistory();
    }

    @GetMapping("/{viewHistoryId}")
    public ViewHistoryDto getViewHistoryById(@PathVariable Long viewHistoryId) {
        return viewHistoryService.getViewHistoryById(viewHistoryId);
    }

    @PostMapping
    public ViewHistoryDto addViewHistory(@RequestBody ViewHistoryDto viewHistoryDto) {
        return viewHistoryService.addViewHistory(viewHistoryDto);
    }

    @DeleteMapping("/{viewHistoryId}")
    public void deleteViewHistoryById(@PathVariable Long viewHistoryId) {
        viewHistoryService.deleteViewHistoryById(viewHistoryId);
    }
}
