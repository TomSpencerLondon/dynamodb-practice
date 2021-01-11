package com.example.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.util.List;

@DynamoDBDocument
public class Genre {
  List<String> genres;

  public List<String> getGenres() {
    return genres;
  }

  public void setGenres(List<String> genres) {
    this.genres = genres;
  }
}
