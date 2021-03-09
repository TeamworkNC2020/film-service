package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Review;
import com.moviesandchill.film.service.dto.ReviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface ReviewMapper {

    Review dtoToReview(ReviewDto review_dto);

    ReviewDto reviewToDto(Review review);

    List<Review> listDtoToListReview(List<ReviewDto> list_review_dto);

    List<ReviewDto> listReviewToListDto(List<Review> list_review);
}
