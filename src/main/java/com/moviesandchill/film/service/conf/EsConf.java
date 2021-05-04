package com.moviesandchill.film.service.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviesandchill.film.service.dto.FilmDto;
import com.moviesandchill.film.service.service.FilmService;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Configuration
public class EsConf {

    @Autowired
    FilmService filmService ;
    String usernameElastic;
    String passwordElastic;
    String hostElastic;
    Integer portElastic;

    @Bean
    public RestHighLevelClient esClient(){
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(usernameElastic, passwordElastic));
        RestHighLevelClient restClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost(hostElastic, portElastic,"https"))
                        .setHttpClientConfigCallback(httpAsyncClientBuilder ->
                                httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider)
                                        .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())));
        return restClient;
    }

    @PostConstruct
    public void loadIndexFilm() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        RestHighLevelClient esClient = esClient();
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

    @Autowired
    public void setElasticSettings(@Value("${endpoint.elastic-username}") String usernameElastic,
                                  @Value("${endpoint.elastic-password}") String passwordElastic,
                                  @Value("${endpoint.elastic-host}") String hostElastic,
                                  @Value("${endpoint.elastic-port}") Integer portElastic) {
        this.usernameElastic = usernameElastic;
        this.passwordElastic = passwordElastic;
        this.hostElastic = hostElastic;
        this.portElastic = portElastic;
    }

}
