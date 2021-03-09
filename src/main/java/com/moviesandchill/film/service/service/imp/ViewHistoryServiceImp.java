package com.moviesandchill.film.service.service.imp;

import com.moviesandchill.film.service.domain.ViewHistory;
import com.moviesandchill.film.service.dto.ViewHistoryDto;
import com.moviesandchill.film.service.mapper.ViewHistoryMapper;
import com.moviesandchill.film.service.repositories.ViewHistoryRepository;
import com.moviesandchill.film.service.service.ViewHistoryService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViewHistoryServiceImp implements ViewHistoryService {

    @Autowired
    ViewHistoryRepository viewHistoryRepository;
    private  final ViewHistoryMapper viewHistoryMapper = Mappers.getMapper(ViewHistoryMapper.class);

    @Override
    public List<ViewHistoryDto> getAllViewHistory() {
        List<ViewHistory> viewHistories = viewHistoryRepository.findAll();
        return viewHistoryMapper.listViewHistoryToListDto(viewHistories);
    }

    @Override
    public void deleteAllViewHistory() {
        viewHistoryRepository.deleteAll();
    }

    @Override
    public ViewHistoryDto getViewHistoryById(Long viewHistoryId) {
        Optional<ViewHistory> viewHistory = viewHistoryRepository.findById(viewHistoryId);
        return viewHistory.map(viewHistoryMapper::viewHistoryToDto).orElse(null);
    }

    @Override
    public ViewHistoryDto addViewHistory(ViewHistoryDto viewHistoryDto) {
        ViewHistory viewHistory = viewHistoryMapper.dtoToViewHistory(viewHistoryDto);
        viewHistory = viewHistoryRepository.save(viewHistory);
        return viewHistoryMapper.viewHistoryToDto(viewHistory);
    }

    @Override
    public void deleteViewHistoryById(Long viewHistoryId) {
        viewHistoryRepository.deleteById(viewHistoryId);
    }
}
