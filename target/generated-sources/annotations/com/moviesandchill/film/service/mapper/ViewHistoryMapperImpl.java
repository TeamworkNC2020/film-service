package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.ViewHistory;
import com.moviesandchill.film.service.dto.ViewHistoryDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-05T15:02:55+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
public class ViewHistoryMapperImpl implements ViewHistoryMapper {

    @Override
    public ViewHistory dtoToViewHistory(ViewHistoryDto view_history_dto) {
        if ( view_history_dto == null ) {
            return null;
        }

        ViewHistory viewHistory = new ViewHistory();

        return viewHistory;
    }

    @Override
    public ViewHistoryDto viewHistoryToDto(ViewHistory view_history) {
        if ( view_history == null ) {
            return null;
        }

        ViewHistoryDto viewHistoryDto = new ViewHistoryDto();

        return viewHistoryDto;
    }

    @Override
    public List<ViewHistory> listDtoToListViewHistory(List<ViewHistoryDto> list_view_history_dto) {
        if ( list_view_history_dto == null ) {
            return null;
        }

        List<ViewHistory> list = new ArrayList<ViewHistory>( list_view_history_dto.size() );
        for ( ViewHistoryDto viewHistoryDto : list_view_history_dto ) {
            list.add( dtoToViewHistory( viewHistoryDto ) );
        }

        return list;
    }

    @Override
    public List<ViewHistoryDto> listViewHistoryToListDto(List<ViewHistory> list_view_history) {
        if ( list_view_history == null ) {
            return null;
        }

        List<ViewHistoryDto> list = new ArrayList<ViewHistoryDto>( list_view_history.size() );
        for ( ViewHistory viewHistory : list_view_history ) {
            list.add( viewHistoryToDto( viewHistory ) );
        }

        return list;
    }
}
