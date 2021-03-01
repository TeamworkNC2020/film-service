package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.View_history;
import com.moviesandchill.film.service.dto.ViewHistoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ViewHistoryMapper {

    View_history dtoToViewHistory(ViewHistoryDto view_history_dto);

    ViewHistoryDto viewHistoryToDto(View_history view_history);

    List<View_history> listDtoToListViewHistory(List<ViewHistoryDto> list_view_history_dto);

    List<ViewHistoryDto> listViewHistoryToListDto(List<View_history> list_view_history);

}
