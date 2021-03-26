package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Screenshot;
import com.moviesandchill.film.service.dto.ScreenshotDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface ScreenshotMapper {

    Screenshot dtoToScreenshot(ScreenshotDto screenshotDto);

    ScreenshotDto screenshotToDto(Screenshot screenshot);

    List<Screenshot> listDtoToListScreenshot(List<ScreenshotDto> listScreenshotDto);

    List<ScreenshotDto> listScreenshotToListDto(List<Screenshot> listScreenshot);
}
