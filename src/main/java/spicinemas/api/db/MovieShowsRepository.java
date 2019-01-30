package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SelectOnConditionStep;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Movie;
import spicinemas.api.model.MovieShow;

import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class MovieShowsRepository {

    @Autowired
    private DSLContext dsl;

    public List<MovieShow> getShows() {
        SelectOnConditionStep genericQuery = this.getGenericQuery();

        return  genericQuery
                .fetch()
                .into(MovieShow.class);
    }


  public List<MovieShow> getShowsByMovieName(String movieName) {
    return this.getGenericQuery()
    .where(DSL.field("MOVIE.NAME").eq(movieName))
    .fetch()
    .into(MovieShow.class);
  }

  private SelectOnConditionStep getGenericQuery(){
    return dsl
    .select(
      DSL.field("MOVIE_SHOWS.ID").as("ID"),
      DSL.field("MOVIE.NAME").as("MOVIE_NAME"),
      DSL.field("THEATERS.NAME").as("THEATER_NAME"),
      DSL.field("THEATERS.CAPACITY").as("THEATER_CAPACITY"),
      DSL.field("SOUND_SYSTEMS.TYPE").as("EXPERIENCE"),
      DSL.field("MOVIE.RUNTIME").as("RUNTIME"),
      DSL.field("MOVIE_SHOWS.START_TIME").as("START_TIME"),
      DSL.field("MOVIE_SHOWS.END_TIME").as("END_TIME")
    )
    .from(DSL.table("MOVIE_SHOWS"))
    .leftOuterJoin(DSL.table("MOVIE"))
    .on(DSL.field("MOVIE_SHOWS.MOVIE_ID").eq(DSL.field("MOVIE.ID")))
    .leftOuterJoin(DSL.table("THEATERS"))
    .on(DSL.field("MOVIE_SHOWS.THEATER_ID").eq(DSL.field("THEATERS.ID")))
    .leftOuterJoin(DSL.table("SOUND_SYSTEMS"))
    .on(DSL.field("MOVIE_SHOWS.SOUND_SYSTEM_ID").eq(DSL.field("SOUND_SYSTEMS.ID")));
  }

  public List<MovieShow> getShowsByMovieID(Long id) {
      return this.getGenericQuery()
      .where(DSL.field("MOVIE.ID").eq(id))
      .fetch()
      .into(MovieShow.class);
  }
}
