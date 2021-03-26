package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Screenshot;
import com.moviesandchill.film.service.dto.ScreenshotDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-26T16:26:15+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class ScreenshotMapperImpl implements ScreenshotMapper {

    @Override
    public Screenshot dtoToScreenshot(ScreenshotDto screenshotDto) {
        if ( screenshotDto == null ) {
            return null;
        }

        Screenshot screenshot = new Screenshot();

        if ( screenshotDto.getId_screenshot() != null ) {
            screenshot.setId_screenshot( screenshotDto.getId_screenshot() );
        }
        if ( screenshotDto.getScreenshot() != null ) {
            screenshot.setScreenshot( screenshotDto.getScreenshot() );
        }

        return screenshot;
    }

    @Override
    public ScreenshotDto screenshotToDto(Screenshot screenshot) {
        if ( screenshot == null ) {
            return null;
        }

        ScreenshotDto screenshotDto = new ScreenshotDto();

        if ( screenshot.getId_screenshot() != null ) {
            screenshotDto.setId_screenshot( screenshot.getId_screenshot() );
        }
        if ( screenshot.getScreenshot() != null ) {
            screenshotDto.setScreenshot( screenshot.getScreenshot() );
        }

        return screenshotDto;
    }

    @Override
    public List<Screenshot> listDtoToListScreenshot(List<ScreenshotDto> listScreenshotDto) {
        if ( listScreenshotDto == null ) {
            return null;
        }

        List<Screenshot> list = new ArrayList<Screenshot>( listScreenshotDto.size() );
        for ( ScreenshotDto screenshotDto : listScreenshotDto ) {
            list.add( dtoToScreenshot( screenshotDto ) );
        }

        return list;
    }

    @Override
    public List<ScreenshotDto> listScreenshotToListDto(List<Screenshot> listScreenshot) {
        if ( listScreenshot == null ) {
            return null;
        }

        List<ScreenshotDto> list = new ArrayList<ScreenshotDto>( listScreenshot.size() );
        for ( Screenshot screenshot : listScreenshot ) {
            list.add( screenshotToDto( screenshot ) );
        }

        return list;
    }
}
