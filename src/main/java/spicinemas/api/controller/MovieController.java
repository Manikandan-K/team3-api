package spicinemas.api.controller;

import org.springframework.web.bind.annotation.*;
import spicinemas.api.db.MovieRepository;
import spicinemas.api.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import spicinemas.api.model.MoviesFilter;
import spicinemas.api.type.MovieListingType;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieRepository movieRepo;

    @RequestMapping(value = "/init",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void init() {

        movieRepo.addMovie(new Movie("Dunkirk", "U", "Tamil", "something",
                "Action", "crew1, crew2", "cast1, cast2", 120,
                "okay", MovieListingType.NOW_SHOWING));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/movies")
    public List<Movie> getMovies(@RequestParam(name = "type") String type, @RequestParam(name = "location") long location){
        return movieRepo.getMovies(new MoviesFilter(type,location));
    }

    @Deprecated
    @RequestMapping(value = "/movies/now-showing",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getNowShowingMovies() {
        return movieRepo.getNowShowingMovies();
    }

    @RequestMapping(value = "/movies/{id}",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovieDetail(@PathVariable Long id) {
        return movieRepo.getMovie(id);
    }

}
