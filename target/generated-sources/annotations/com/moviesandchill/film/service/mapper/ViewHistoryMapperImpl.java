package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.ViewHistory;
import com.moviesandchill.film.service.dto.ViewHistoryDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-23T16:39:48+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class ViewHistoryMapperImpl implements ViewHistoryMapper {

    @Override
    public ViewHistory dtoToViewHistory(ViewHistoryDto view_history_dto) {
        if ( view_history_dto == null ) {
            return null;
        }

        ViewHistory viewHistory = new ViewHistory();

        if ( view_history_dto.getId_view_history() != null ) {
            viewHistory.setId_view_history( view_history_dto.getId_view_history() );
        }
        if ( view_history_dto.getTime_movie_watching() != null ) {
            viewHistory.setTime_movie_watching( view_history_dto.getTime_movie_watching() );
        }
        if ( view_history_dto.getId_user() != null ) {
            viewHistory.setId_user( view_history_dto.getId_user() );
        }

        return viewHistory;
    }

    @Override
    public ViewHistoryDto viewHistoryToDto(ViewHistory view_history) {
        if ( view_history == null ) {
            return null;
        }

        ViewHistoryDto viewHistoryDto = new ViewHistoryDto();

        if ( view_history.getId_view_history() != null ) {
            viewHistoryDto.setId_view_history( view_history.getId_view_history() );
        }
        if ( view_history.getTime_movie_watching() != null ) {
            viewHistoryDto.setTime_movie_watching( view_history.getTime_movie_watching() );
        }
        if ( view_history.getId_user() != null ) {
            viewHistoryDto.setId_user( view_history.getId_user() );
        }

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
