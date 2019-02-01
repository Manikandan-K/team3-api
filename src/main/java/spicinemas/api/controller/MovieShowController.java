package spicinemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spicinemas.api.db.MovieShowsRepository;
import spicinemas.api.model.MovieShow;

import java.util.List;

@RestController
public class MovieShowController {
    @Autowired
    MovieShowsRepository movieShowsRepo;

    @RequestMapping(value = "/movies/{id}/shows",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovieShow> getMovieShowDetail(@PathVariable Long id, @RequestParam String showDate) {

        return movieShowsRepo.getShowsByMovieID(id, showDate);
    }


    @RequestMapping(value = "/movies/{id}/shows/{showId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieShow getMovieShowDetailByShowId(@PathVariable Long id, @PathVariable Long showId) {
        return movieShowsRepo.getMovieShow(id, showId);
    }

}
