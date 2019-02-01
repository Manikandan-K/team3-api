package spicinemas.api.db;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Movie;
import spicinemas.api.model.MoviesFilter;

import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class MovieRepository {
  @Autowired
  private DSLContext dsl;

  public List<Movie> getNowShowingMovies() {
    return dsl.select()
            .from(DSL.table("MOVIE"))
            .fetchInto(Movie.class);
  }

  public void addMovie(Movie movie) {
    dsl.insertInto(
            DSL.table("MOVIE"),
            DSL.field("NAME"),
            DSL.field("CERTIFICATION"),
            DSL.field("LANGUAGE"),
            DSL.field("SYNOPSIS"),
            DSL.field("GENRE"),
            DSL.field("CREW"),
            DSL.field("MOVIE_CAST"),
            DSL.field("RUNTIME"),
            DSL.field("EXPERIENCES"),
            DSL.field("LISTING_TYPE")
    ).values(
            movie.getName(),
            movie.getCertification(),
            movie.getLanguage(),
            movie.getSynopsis(),
            movie.getGenre(),
            movie.getCrew(),
            movie.getMovieCast(),
            movie.getRuntime(),
            movie.getExperiences(),
            movie.getListingType().toString()
    ).execute();

  }

  public Movie getMovie(Long id) {
    return dsl.select()
            .from(DSL.table("MOVIE"))
            .where(DSL.field("MOVIE.ID").eq(id))
            .fetchOne()
            .into(Movie.class);
  }

  public List<Movie> getMovies(MoviesFilter moviesFilter) {
    Condition movieTypeMatch = DSL.field("movie.listing_type").equalIgnoreCase(moviesFilter.getType());
    return dsl.selectDistinct(
            DSL.field("MOVIE.ID").as("ID"),
            DSL.field("MOVIE.NAME").as("NAME"),
            DSL.field("MOVIE.CERTIFICATION").as("CERTIFICATION"),
            DSL.field("MOVIE.LANGUAGE").as("LANGUAGE"),
            DSL.field("MOVIE.SYNOPSIS").as("SYNOPSIS"),
            DSL.field("MOVIE.GENRE").as("GENRE"),
            DSL.field("MOVIE.CREW").as("CREW"),
            DSL.field("MOVIE.MOVIE_CAST").as("MOVIE_CAST"),
            DSL.field("MOVIE.RUNTIME").as("RUNTIME"),
            DSL.field("MOVIE.EXPERIENCES").as("EXPERIENCES"),
            DSL.field("MOVIE.LISTING_TYPE").as("LISTING_TYPE"))
            .from(DSL.table("movie"))
            .innerJoin(DSL.table("movie_shows")).on(DSL.field("movie.id").eq(DSL.field("movie_shows.movie_id")))
            .innerJoin(DSL.table("theaters")).on(DSL.field("movie_shows.theater_id").eq(DSL.field("theaters.id")))
            .innerJoin(DSL.table("locations")).on(DSL.field("theaters.location_id").eq(DSL.field("locations.id")))
            .where(movieTypeMatch.and(DSL.field("locations.id").eq(moviesFilter.getLocationId())))
            .fetchInto(Movie.class);
  }
}
