package spicinemas.api.controller;

import org.springframework.web.bind.annotation.*;
import spicinemas.api.db.MovieRepository;
import spicinemas.api.db.MovieShowsRepository;
import spicinemas.api.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import spicinemas.api.model.MovieShow;
import spicinemas.api.type.MovieListingType;

import java.text.ParseException;
import java.util.List;

@RestController
public class MovieShowController {
  @Autowired
  MovieShowsRepository movieShowsRepo;

  @RequestMapping(value = "/movies/{id}/shows",
          method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<MovieShow> getMovieShowDetail(@PathVariable Long id, @RequestParam String showDate) throws ParseException {
    return movieShowsRepo.getShowsByMovieID(id, showDate);
  }

}
