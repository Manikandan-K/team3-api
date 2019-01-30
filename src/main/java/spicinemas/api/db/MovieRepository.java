package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
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
    return dsl.select()
            .from(DSL.table("movie"))
            .innerJoin(DSL.table("movie_shows")).on(DSL.field("movie.id").eq(DSL.field("movie_shows.movie_id")))
            .innerJoin(DSL.table("theaters")).on(DSL.field("movie_shows.theater_id").eq(DSL.field("theaters.id")))
            .innerJoin(DSL.table("locations")).on(DSL.field("theaters.location_id").eq(DSL.field("locations.id")))
            .where(DSL.field("movie.listing_type").equalIgnoreCase(moviesFilter.getType()).and(DSL.field("locations.name").likeIgnoreCase(moviesFilter.getLocation())))
            .fetchInto(Movie.class);
  }
}
