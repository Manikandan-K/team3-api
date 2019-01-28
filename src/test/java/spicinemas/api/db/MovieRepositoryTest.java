package spicinemas.api.db;

import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.Movie;
import spicinemas.api.type.MovieListingType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class MovieRepositoryTest {
    @Autowired
    DSLContext dslContext;
    @Autowired
    private MovieRepository movieRepo;

    @Test
    public void shouldInsertUserInDb() {
        String movieName = "Infinity War";
        Movie expectedMovie = new Movie(movieName, "U", "Tamil", "something",
                "Action", "crew1, crew2", "cast1, cast2", 120,
                "okay", MovieListingType.NOW_SHOWING);
        movieRepo.addMovie(expectedMovie);
        Movie actualMovie = movieRepo.getMovie(movieName);
        assertThat(actualMovie.getName(), is(expectedMovie.getName()));
        assertThat(actualMovie.getExperiences(), is(expectedMovie.getExperiences()));
        assertThat(actualMovie.getListingType(), is(expectedMovie.getListingType()));
    }

    @Test
    public void shouldFetchMovieDetailsForGivenMovie() {
        String movieName = "Kabali";
        Movie actualMovie = movieRepo.getMovie(movieName);
        assertThat(movieName, is(actualMovie.getName()));
    }
}