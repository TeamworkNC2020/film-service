package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.ViewHistory;
import com.moviesandchill.film.service.dto.ViewHistoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface ViewHistoryMapper {

    ViewHistory dtoToViewHistory(ViewHistoryDto view_history_dto);

    ViewHistoryDto viewHistoryToDto(ViewHistory view_history);

    List<ViewHistory> listDtoToListViewHistory(List<ViewHistoryDto> list_view_history_dto);

    List<ViewHistoryDto> listViewHistoryToListDto(List<ViewHistory> list_view_history);

}
