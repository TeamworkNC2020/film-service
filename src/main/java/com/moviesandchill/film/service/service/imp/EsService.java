package com.moviesandchill.film.service.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviesandchill.film.service.domain.Film;
import com.moviesandchill.film.service.domain.Genre;
import com.moviesandchill.film.service.domain.Staff;
import com.moviesandchill.film.service.dto.*;
import com.moviesandchill.film.service.repositories.FilmRepository;
import com.moviesandchill.film.service.service.FilmService;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class EsService {

    private final RestHighLevelClient esClient;
    private FilmService filmService;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public EsService(RestHighLevelClient esClient, FilmService filmService) {
        this.esClient = esClient;
        this.filmService = filmService;
    }

    public SearchFilm getSearchFilm(Long filmId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Film film = session.find(Film.class, filmId);
        SearchFilm result = new SearchFilm();
        result.setIdFilm(film.getIdFilm());
        result.setFilmTitle(film.getFilmTitle());
        result.setDuration(film.getDuration());
        result.setReleaseDate(film.getReleaseDate());
        result.setFilmPoster(film.getFilmPoster());
        result.setFilmTrailer(film.getFilmTrailer());
        result.setFilmVideo(film.getFilmVideo());
        result.setFilmBudget(film.getFilmBudget());
        result.setDescription(film.getDescription());
        if(film.getAge_limit() != null){
            result.setIdages(film.getAge_limit().getId_age_limit());
        }
        if(film.getGenres() != null){
            for(Genre genr : film.getGenres()){
                result.getIdgenres().add(genr.getId_genre());
            }
        }
        if(film.getStaffs() != null){
            for(Staff prod : film.getStaffs()){
                if(prod.getStaff_role().getRoleTitle().equals("Режиссер")){
                    result.getIdproducers().add(prod.getId_staff());
                }
            }
        }

        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void loadIndexFilm() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Film> filmList = filmRepository.findAll();
        if(esClient.indices().exists(new GetIndexRequest("films"),RequestOptions.DEFAULT)){
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("films");
            esClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        }
        esClient.indices().create(new CreateIndexRequest("films"),RequestOptions.DEFAULT);
        for(Film film : filmList){
            SearchFilm searchFilm = getSearchFilm(film.getIdFilm());
            IndexRequest indexRequest = new IndexRequest("films");
            indexRequest.id(UUID.randomUUID().toString());
            indexRequest.source(objectMapper.writeValueAsString(searchFilm), XContentType.JSON);
            esClient.index(indexRequest, RequestOptions.DEFAULT);
        }
    }

    public void loadFilm(Long filmId) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        SearchFilm searchFilm = getSearchFilm(filmId);
        IndexRequest indexRequest = new IndexRequest("films");
        indexRequest.id(UUID.randomUUID().toString());
        indexRequest.source(objectMapper.writeValueAsString(searchFilm), XContentType.JSON);
        esClient.index(indexRequest, RequestOptions.DEFAULT);
    }

    public List<FilmPageDto> search(String searchString, Filter filter) throws IOException {
        SearchRequest searchRequest = new SearchRequest("films");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder qb = QueryBuilders.boolQuery()
                .should(new RegexpQueryBuilder("filmTitle",searchString+ ".*"))
                .should(QueryBuilders.multiMatchQuery(searchString,"filmTitle")
                .fuzziness(Fuzziness.AUTO));
        if(!filter.getIdages().isEmpty()){
            qb.must(new TermsQueryBuilder("idages",filter.getIdages().toArray()));
        }
        if(!filter.getIdgenres().isEmpty()){
            qb.must(new TermsQueryBuilder("idgenres", filter.getIdgenres().toArray()));
        }
        if(!filter.getIdproducers().isEmpty()){
            qb.must(new TermsQueryBuilder("idproducers", filter.getIdproducers().toArray()));
        }
        sourceBuilder.query(qb);

        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        List<FilmPageDto> filmDtoList = new ArrayList<>();
        for(SearchHit searchHit : searchResponse.getHits().getHits()){
            Map<String,Object> sourse = searchHit.getSourceAsMap();

            FilmPageDto filmDto = new FilmPageDto();
            filmDto.setId(Long.valueOf((int) sourse.get("idFilm")));
            filmDto.setName((String) sourse.get("filmTitle"));
            filmDto.setLogo((String) sourse.get("filmPoster"));
            filmDto.setRating(filmService.getRatingFilmById(filmDto.getId()));
            AgeLimitDto age = filmService.getAgeLimitByFilmId(filmDto.getId());
            if(age != null){
                filmDto.setAgeRestrictions(age.getTitle());
            }
            filmDtoList.add(filmDto);
        }
        return filmDtoList;
    }
}
