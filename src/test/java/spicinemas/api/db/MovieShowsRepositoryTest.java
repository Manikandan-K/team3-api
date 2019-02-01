package spicinemas.api.db;

import org.flywaydb.core.Flyway;
import org.jooq.DSLContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.MovieShow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")

public class MovieShowsRepositoryTest {
    @Autowired
    DSLContext dslContext;
    @Autowired
    private MovieShowsRepository movieShowsRepo;

    @Autowired
    private Flyway flyway;


    @Before
    public void init() {
        flyway.clean();
        flyway.migrate();
    }


    @Test
    public void shouldReturnAllMovieShows() throws ParseException {
        String movieName = "Infinity War";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        MovieShow expectedShow = new MovieShow(1, "Remo", "PVR", 500, "Dolby", 150, sdf.parse("2019-01-29 19:10"), sdf.parse("2019-01-29 21:10"), "Tamil", 500);

        List<MovieShow> movieShows = movieShowsRepo.getShows();
        MovieShow actualShow = movieShows.get(11);
        assertEquals(expectedShow, actualShow);
        assertEquals(44, movieShows.size());
    }

    @Test
    public void shouldReturnMovieShowsWhenSearchedByMovieName() throws ParseException {
        String movieName = "Kabali";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        MovieShow expectedShow = new MovieShow(2, "Kabali", "PVR", 500, "Dolby", 150, sdf.parse("2019-01-30 10:00"), sdf.parse("2019-01-29 13:00"), "Tamil", 500);

        List<MovieShow> movieShows = movieShowsRepo.getShowsByMovieName(movieName);
        MovieShow actualShow = movieShows.get(0);
        assertEquals(expectedShow, actualShow);
    }

    @Test
    public void shouldMovieShowsByMovieID() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        MovieShow expectedShow = new MovieShow(2, "Kabali", "PVR", 500, "Dolby", 150, sdf.parse("2019-01-30 10:00"), sdf.parse("2019-01-29 13:00"), "Tamil", 500);

        List<MovieShow> movieShows = movieShowsRepo.getShowsByMovieID(1L);

        MovieShow expectedMovieShow = movieShows.get(0);

        assertEquals(expectedShow, expectedMovieShow);
    }

    @Test
    public void shouldMovieShowsByMovieIDAndShowDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        MovieShow expectedShow = new MovieShow(2, "Kabali", "PVR", 500, "Dolby", 150, sdf.parse("2019-01-30 10:00"), sdf.parse("2019-01-29 13:00"), "Tamil", 500);

        List<MovieShow> movieShows = movieShowsRepo.getShowsByMovieID(1L, "2019-01-30");

        MovieShow expectedMovieShow = movieShows.get(0);

        assertEquals(expectedShow, expectedMovieShow);
    }

    @Test
    public void shouldMovieShowsByMovieIDAndShowDateAndNumberOfRequiredTickets() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        MovieShow expectedShow = new MovieShow(2, "Kabali", "PVR", 500, "Dolby", 150, sdf.parse("2019-01-30 10:00"), sdf.parse("2019-01-29 13:00"), "Tamil", 500);

        List<MovieShow> movieShows = movieShowsRepo.getShowsByMovieID(1L, "2019-01-30");
        MovieShow expectedMovieShow = movieShows.get(0);
        assertEquals(expectedShow, expectedMovieShow);
    }

    @Test
    public void shouldGetMovieShowByMovieIdAndShowId() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        MovieShow expectedShow = new MovieShow(2, "Kabali", "PVR", 500, "Dolby", 150, sdf.parse("2019-01-30 10:00"), sdf.parse("2019-01-29 13:00"), "Tamil", 500);

        MovieShow actualShow = movieShowsRepo.getMovieShow(1L, 2L);

        assertEquals(expectedShow, actualShow);
    }

}
