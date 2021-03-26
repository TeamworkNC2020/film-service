package com.moviesandchill.film.service.mapper;

import com.moviesandchill.film.service.domain.Review;
import com.moviesandchill.film.service.dto.ReviewDto;
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
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review dtoToReview(ReviewDto review_dto) {
        if ( review_dto == null ) {
            return null;
        }

        Review review = new Review();

        if ( review_dto.getId_review() != null ) {
            review.setId_review( review_dto.getId_review() );
        }
        if ( review_dto.getRating_film() != null ) {
            review.setRating_film( review_dto.getRating_film() );
        }
        if ( review_dto.getReview() != null ) {
            review.setReview( review_dto.getReview() );
        }
        if ( review_dto.getReview_date() != null ) {
            review.setReview_date( review_dto.getReview_date() );
        }
        if ( review_dto.getId_user() != null ) {
            review.setId_user( review_dto.getId_user() );
        }

        return review;
    }

    @Override
    public ReviewDto reviewToDto(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewDto reviewDto = new ReviewDto();

        if ( review.getId_review() != null ) {
            reviewDto.setId_review( review.getId_review() );
        }
        if ( review.getRating_film() != null ) {
            reviewDto.setRating_film( review.getRating_film() );
        }
        if ( review.getReview() != null ) {
            reviewDto.setReview( review.getReview() );
        }
        if ( review.getReview_date() != null ) {
            reviewDto.setReview_date( review.getReview_date() );
        }
        if ( review.getId_user() != null ) {
            reviewDto.setId_user( review.getId_user() );
        }

        return reviewDto;
    }

    @Override
    public List<Review> listDtoToListReview(List<ReviewDto> list_review_dto) {
        if ( list_review_dto == null ) {
            return null;
        }

        List<Review> list = new ArrayList<Review>( list_review_dto.size() );
        for ( ReviewDto reviewDto : list_review_dto ) {
            list.add( dtoToReview( reviewDto ) );
        }

        return list;
    }

    @Override
    public List<ReviewDto> listReviewToListDto(List<Review> list_review) {
        if ( list_review == null ) {
            return null;
        }

        List<ReviewDto> list = new ArrayList<ReviewDto>( list_review.size() );
        for ( Review review : list_review ) {
            list.add( reviewToDto( review ) );
        }

        return list;
    }
}
