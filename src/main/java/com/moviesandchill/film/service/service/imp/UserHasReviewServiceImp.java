package com.moviesandchill.film.service.service.imp;

import com.moviesandchill.film.service.domain.UserHasReview;
import com.moviesandchill.film.service.dto.UserHasReviewDto;
import com.moviesandchill.film.service.mapper.FilmMapper;
import com.moviesandchill.film.service.mapper.UserHasReviewMapper;
import com.moviesandchill.film.service.repositories.UserHasReviewRepository;
import com.moviesandchill.film.service.service.UserHasReviewService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserHasReviewServiceImp implements UserHasReviewService {

    @Autowired
    UserHasReviewRepository userHasReviewRepository;
    private final UserHasReviewMapper userHasReviewMapper = Mappers.getMapper(UserHasReviewMapper.class);

    @Override
    public List<UserHasReviewDto> getAllUserHasReview() {
        List<UserHasReview> userHasReviews = userHasReviewRepository.findAll();
        return userHasReviewMapper.listUserHasReviewToListDto(userHasReviews);
    }

    @Override
    public void deleteAllUserHasReview() {
        userHasReviewRepository.deleteAll();
    }

    @Override
    public UserHasReviewDto getUserHasReviewById(Long userHasReviewId) {
        Optional<UserHasReview> userHasReview = userHasReviewRepository.findById(userHasReviewId);
        return userHasReview.map(userHasReviewMapper::userHasReviewToDto).orElse(null);
    }

    @Override
    public UserHasReviewDto addUserHasReview(UserHasReviewDto userHasReviewDto) {
        UserHasReview userHasReview = userHasReviewMapper.dtoToUserHasReview(userHasReviewDto);
        userHasReview = userHasReviewRepository.save(userHasReview);
        return userHasReviewMapper.userHasReviewToDto(userHasReview);
    }

    @Override
    public void deleteUserHasReviewById(Long userHasReviewId) {
        userHasReviewRepository.deleteById(userHasReviewId);
    }
}
