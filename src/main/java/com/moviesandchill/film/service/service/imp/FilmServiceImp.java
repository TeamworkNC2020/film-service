package com.moviesandchill.film.service.service.imp;

import com.moviesandchill.film.service.domain.*;
import com.moviesandchill.film.service.dto.*;
import com.moviesandchill.film.service.mapper.*;
import com.moviesandchill.film.service.repositories.*;
import com.moviesandchill.film.service.service.FilmService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FilmServiceImp implements FilmService {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    ViewHistoryRepository viewHistoryRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ScreenshotRepository screenshotRepository;
    @Autowired
    AgeLimitRepository ageLimitRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    StaffRoleRepository staffRoleRepository;
    @Autowired
    FilmMapper filmMapper;
    @Autowired
    StaffMapper staffMapper;
    @Autowired
    GenreMapper genreMapper;
    @Autowired
    AgeLimitMapper ageLimitMapper;
    @Autowired
    ViewHistoryMapper viewHistoryMapper;
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    ScreenshotMapper screenshotMapper;
    @Autowired
    CountryMapper countryMapper;

    @Override
    public List<FilmDto> getAllFilm() {
        List<Film> films = filmRepository.findAll();
        return filmMapper.listFilmToListDto(films);
    }

    @Override
    public List<FilmPageDto> getFirstPopularFilms() {
        List<FilmPageDto> result = new ArrayList<>();
        Pageable page = PageRequest.of(0, 8,Sort.by(Sort.Direction.DESC, "rating"));
        List<Object[]> popularFilm = filmRepository.findPopularIdFilm(page);
        if(!popularFilm.isEmpty()) {
            List<Long> idlist = new ArrayList<>();
            Map<Long,Float> mapfilms = new HashMap<>();
            for(Object[] obj : popularFilm){
                idlist.add((Long) obj[0]);
                mapfilms.put((Long) obj[0],(Float) obj[1]);
            }
            Iterable<Long> iterId = idlist;
            List<Film> Film = filmRepository.findFilmIds(iterId);
            for(Film film : Film){
                result.add(FilmMapper.filmToPage(film,
                        getRatingFilmById(film.getIdFilm()),
                        getAgeLimitByFilmId(film.getIdFilm())));
            }
        }
        return result;
    }

    @Override
    public List<FilmPageDto> getFirstNewFilms() {
        Pageable page = PageRequest.of(0, 8,Sort.by(Sort.Direction.DESC, "releaseDate"));
        List<Film> films = filmRepository.findAll(page).getContent();
        List<FilmPageDto> filmPageDtos = new ArrayList<>();
        for(Film film : films){
            filmPageDtos.add(FilmMapper.filmToPage(film,
                    getRatingFilmById(film.getIdFilm()),
                    getAgeLimitByFilmId(film.getIdFilm())));
        }
        return filmPageDtos;
    }

    @Override
    public List<FilmPageDto> getRandomThreeFilms() {
        int len = (int) filmRepository.count()/ 3;
        int idx =(int) new Random().nextInt(len);
        List<Film> films = filmRepository.findAll(PageRequest.of(idx, 3)).getContent();
        List<FilmPageDto> filmPageDtos = new ArrayList<>();
        for(Film film : films){
            filmPageDtos.add(FilmMapper.filmToPage(film,
                    getRatingFilmById(film.getIdFilm()),
                    getAgeLimitByFilmId(film.getIdFilm())));
        }
        return filmPageDtos;
    }

    @Override
    public void deleteAllFilm() {
        filmRepository.deleteAll();
    }

    @Override
    public FilmDto getFilmById(Long film_id) {
        Optional<Film> film = filmRepository.findById(film_id);
        return film.map(filmMapper::filmToDto).orElse(null);
    }

    @Override
    public FilmDto addFilm(FilmDto film_dto) {
        Film film = filmMapper.dtoToFilm(film_dto);
        film = filmRepository.save(film);
        return filmMapper.filmToDto(film);
    }

    @Override
    public void deleteFilmById(Long film_id) {
        filmRepository.deleteById(film_id);
    }

    @Override
    public List<GenreDto> getAllGenreWithFilm(Long film_id) {
        Optional<Film> film = filmRepository.findById(film_id);
        if (film.isPresent()) {
            List<Genre> genres = new ArrayList<>(film.get().getGenres());
            return genreMapper.listGenreToListDto(genres);
        }
        return null;
    }

    @Override
    public float getRatingFilmById(Long film_id) {
        List<Object[]> rating = filmRepository.findRatingFilmById(film_id);
        if(!rating.isEmpty() && rating.get(0)[0] != null) {
            String ratingFilm = rating.get(0)[0].toString();
            return Float.parseFloat(ratingFilm);
        }
        return 0;
    }

    @Override
    public AgeLimitDto getAgeLimitByFilmId(Long film_id) {
        Optional<Film> film = filmRepository.findById(film_id);
        if (film.isPresent()) {
            AgeLimit ageLimit = film.get().getAge_limit();
            return ageLimitMapper.ageLimitToDto(ageLimit);
        }
        return null;
    }

    @Override
    public void setAgeLimitByFilmId(Long film_id, Long ageLimitID) throws Exception {
        Film film = filmRepository.findById(film_id).orElseThrow(() -> new Exception());
        AgeLimit ageLimit = ageLimitRepository.findById(ageLimitID).orElseThrow(() -> new Exception());
        film.setAge_limit(ageLimit);
        filmRepository.save(film);
    }

    @Override
    public CountryDto getCountryByFilmId(Long film_id) {
        Optional<Film> film = filmRepository.findById(film_id);
        if (film.isPresent()) {
            Country country = film.get().getCountry();
            return countryMapper.countryToDto(country);
        }
        return null;
    }

    @Override
    public void setCountryByFilmId(Long film_id, Long countryID) throws Exception {
        Film film = filmRepository.findById(film_id).orElseThrow(() -> new Exception());
        Country country = countryRepository.findById(countryID).orElseThrow(() -> new Exception());
        film.setCountry(country);
        filmRepository.save(film);
    }

    @Override
    public void addGenreToFilm(Long film_id, Long genre_id) throws Exception {
        Film film = filmRepository.findById(film_id).orElseThrow(() -> new Exception());
        Genre genre = genreRepository.findById(genre_id).orElseThrow(() -> new Exception());
        film.getGenres().add(genre);
        filmRepository.save(film);
        genre.getFilms().add(film);
        genreRepository.save(genre);
    }

    @Override
    public List<StaffDto> getAllStaffWithFilm(Long film_id) {
        Optional<Film> film = filmRepository.findById(film_id);
        if (film.isPresent()) {
            List<Staff> staffs = new ArrayList<>(film.get().getStaffs());
            return staffMapper.listStaffToListDto(staffs);
        }
        return null;
    }

    @Override
    public List<StaffDto> getAllActorsByFilm(Long film_id) throws Exception {
        Optional<StaffRole> staffRole = staffRoleRepository.findByRoleTitle("Актер");
        if(staffRole.isPresent()){
            List<Staff> actors = staffRepository.findStaffByRoleAndFilm(staffRole.get().getId_staff_role(),film_id);
            return staffMapper.listStaffToListDto(actors);
        }
        return null;
    }

    @Override
    public List<StaffDto> getAllProducersByFilm(Long film_id) throws Exception{
        Optional<StaffRole> staffRole = staffRoleRepository.findByRoleTitle("Режиссер");
        if(staffRole.isPresent()){
            List<Staff> producers = staffRepository.findStaffByRoleAndFilm(staffRole.get().getId_staff_role(),film_id);
            return staffMapper.listStaffToListDto(producers);
        }
        return null;
    }

    @Override
    public void addStaffToFilm(Long film_id, Long staff_id) throws Exception {
        Film film = filmRepository.findById(film_id).orElseThrow(() -> new Exception());
        Staff staff = staffRepository.findById(staff_id).orElseThrow(() -> new Exception());
        film.getStaffs().add(staff);
        filmRepository.save(film);
        staff.getFilms().add(film);
        staffRepository.save(staff);
    }

    @Override
    public List<ViewHistoryDto> getAllViewHistoryWithFilm(Long film_id) {
        Optional<Film> film = filmRepository.findById(film_id);
        if (film.isPresent()) {
            List<ViewHistory> viewHistorys = new ArrayList<>(film.get().getView_histories());
            return viewHistoryMapper.listViewHistoryToListDto(viewHistorys);
        }
        return null;
    }

    @Override
    public void addViewHistoryToFilm(Long film_id, Long viewHistory_id) throws Exception {
        Film film = filmRepository.findById(film_id).orElseThrow(() -> new Exception());
        ViewHistory viewHistory = viewHistoryRepository.findById(viewHistory_id).orElseThrow(() -> new Exception());
        film.getView_histories().add(viewHistory);
        filmRepository.save(film);
    }

    @Override
    public List<ReviewDto> getAllReviewWithFilm(Long film_id) {
        Optional<Film> film = filmRepository.findById(film_id);
        if (film.isPresent()) {
            List<Review> reviews = new ArrayList<>(film.get().getReviews());
            return reviewMapper.listReviewToListDto(reviews);
        }
        return null;
    }

    @Override
    public void addReviewToFilm(Long film_id, Long review_id) throws Exception {
        Film film = filmRepository.findById(film_id).orElseThrow(() -> new Exception());
        Review review = reviewRepository.findById(review_id).orElseThrow(() -> new Exception());
        film.getReviews().add(review);
        filmRepository.save(film);
    }

    @Override
    public List<ScreenshotDto> getAllScreenshotWithFilm(Long film_id) {
        Optional<Film> film = filmRepository.findById(film_id);
        if (film.isPresent()) {
            List<Screenshot> screenshots = new ArrayList<>(film.get().getScreenshots());
            return screenshotMapper.listScreenshotToListDto(screenshots);
        }
        return null;
    }

    @Override
    public void addScreenshotToFilm(Long film_id, Long screenshot_id) throws Exception {
        Film film = filmRepository.findById(film_id).orElseThrow(() -> new Exception());
        Screenshot screenshot = screenshotRepository.findById(screenshot_id).orElseThrow(() -> new Exception());
        film.getScreenshots().add(screenshot);
        filmRepository.save(film);
    }
}
