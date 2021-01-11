package com.example.dynamodb.web;

import com.example.dto.Movie;
import com.example.dynamodb.service.MovieSearchService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/movies")
public class DynamoDBController {
  private MovieSearchService movieSearchService;

  public DynamoDBController(MovieSearchService movieSearchService) {
    this.movieSearchService = movieSearchService;
  }

  @RequestMapping(value = "/retrieveAllMovies", method = GET)
  public ResponseEntity<List<Movie>> retrieveAllMovies(){
    MultiValueMap<String, String> headers = new HttpHeaders();
    Iterable<Movie> movies = movieSearchService.findAllMovies();
    if (movies != null){
      System.out.println("Movies are not null");
    }

    List<Movie> moviesList = StreamSupport.stream(movies.spliterator(), false).collect(Collectors.toList());

    return new ResponseEntity<List<Movie>>(moviesList, headers, HttpStatus.OK);
  }

  @RequestMapping(value = "/insertMovie", method = GET)
  public void insertMovie(){

    movieSearchService.addNewMovieThroughDynamo();
  }


}
