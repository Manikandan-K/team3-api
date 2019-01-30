package spicinemas.api.controller;

import spicinemas.api.db.MovieRepository;
import spicinemas.api.db.MovieShowsRepository;
import spicinemas.api.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.model.MovieShow;
import spicinemas.api.type.MovieListingType;

import java.util.List;

@RestController
public class MovieShowController {
  @Autowired
  MovieShowsRepository movieShowsRepo;

  @RequestMapping(value = "/movies/{id}/shows",
          method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<MovieShow> getMovieShowDetail(@PathVariable Long id) {
    return movieShowsRepo.getShowsByMovieID(id);
  }

}
