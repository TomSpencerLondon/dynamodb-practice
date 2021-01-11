package com.example.dynamodb.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.example.dto.Movie;
import com.example.dynamodb.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieSearchService {
  @Autowired
  private AmazonDynamoDB amazonDynamoDB;

  public MovieRepository movieRepository;

  public MovieSearchService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<Movie> findAllMovies() {
    return StreamSupport.stream(movieRepository.findAll().spliterator(), true)
        .collect(Collectors.toList());
  }

  public void addNewMovieThroughDynamo() {
    DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
    Table table = dynamoDB.getTable("movie");

    String title = "AWS Training Movie";

    try {
      System.out.println("Starting the insert process");
      PutItemOutcome outcome = table.putItem(new Item().withPrimaryKey("FilmId", 3)
          .with("Plot", "Nothing happens this is a test")
          .with("Rated", "UnApproved")
          .with("Title", title));
      System.out.println("PutItem succeeded: " + outcome.getPutItemResult().toString());
      System.out.println("Successfully inserted");
    }catch (Exception ex){
      ex.printStackTrace();
    }
  }
}
