package com.moviesandchill.film.service.service;

import com.moviesandchill.film.service.dto.ViewHistoryDto;

import java.util.List;

public interface ViewHistoryService {

    List<ViewHistoryDto> getAllViewHistory();

    void deleteAllViewHistory();

    ViewHistoryDto getViewHistoryById(Long viewHistoryId);

    ViewHistoryDto addViewHistory(ViewHistoryDto viewHistoryDto);

    void deleteViewHistoryById(Long viewHistoryId);
}
