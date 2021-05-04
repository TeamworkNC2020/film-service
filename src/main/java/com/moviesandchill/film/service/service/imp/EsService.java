package com.moviesandchill.film.service.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.service.FilmService;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class EsService {

    private final RestHighLevelClient esClient;
    private FilmService filmService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public EsService(RestHighLevelClient esClient, FilmService filmService) {
        this.esClient = esClient;
        this.filmService = filmService;
    }


    public void updateIndexFilm() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<FilmDto> filmDtoList = filmService.getAllFilm();
        if(esClient.indices().exists(new GetIndexRequest("films"),RequestOptions.DEFAULT)){
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("films");
            esClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        }
        esClient.indices().create(new CreateIndexRequest("films"),RequestOptions.DEFAULT);
        for(FilmDto filmDto : filmDtoList){
            IndexRequest indexRequest = new IndexRequest("films");
            indexRequest.id(UUID.randomUUID().toString());
            indexRequest.source(objectMapper.writeValueAsString(filmDto), XContentType.JSON);
            esClient.index(indexRequest, RequestOptions.DEFAULT);
        }
    }

    public List<FilmDto> search(String searchString) throws IOException {
        SearchRequest searchRequest = new SearchRequest("films");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.multiMatchQuery(searchString,"filmTitle","description").fuzziness("AUTO"));

        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        List<FilmDto> filmDtoList = new ArrayList<>();
        for(SearchHit searchHit : searchResponse.getHits().getHits()){
            Map<String,Object> sourse = searchHit.getSourceAsMap();

            FilmDto filmDto = new FilmDto();
            filmDto.setIdFilm(Long.valueOf((int) sourse.get("idFilm")));
            filmDto.setFilmTitle((String) sourse.get("filmTitle"));
            filmDto.setDescription((String) sourse.get("description"));
            filmDtoList.add(filmDto);
        }
        return filmDtoList;
    }
}
