package spicinemas.api.model;

import lombok.Value;

@Value
public class MoviesFilter {
  private String type;
  private String location;
}
