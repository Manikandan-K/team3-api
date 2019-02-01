package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.MovieShow;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.jooq.impl.DSL.field;


@Repository
@Transactional
public class MovieShowsRepository {

    @Autowired
    private DSLContext dsl;

    public List<MovieShow> getShows() {
        SelectOnConditionStep genericQuery = this.getGenericQuery();

        return genericQuery
                .fetch()
                .into(MovieShow.class);
    }


    public List<MovieShow> getShowsByMovieName(String movieName) {
        return this.getGenericQuery()
                .where(DSL.field("MOVIE.NAME").eq(movieName))
                .fetch()
                .into(MovieShow.class);
    }

    private SelectOnConditionStep getGenericQuery() {
        return dsl
                .select(
                        DSL.field("MOVIE_SHOWS.ID").as("ID"),
                        DSL.field("MOVIE.NAME").as("MOVIE_NAME"),
                        DSL.field("THEATERS.NAME").as("THEATER_NAME"),
                        DSL.field("THEATERS.CAPACITY").as("THEATER_CAPACITY"),
                        DSL.field("SOUND_SYSTEMS.TYPE").as("EXPERIENCE"),
                        DSL.field("MOVIE.RUNTIME").as("RUNTIME"),
                        DSL.field("MOVIE_SHOWS.START_TIME").as("START_TIME"),
                        DSL.field("MOVIE_SHOWS.END_TIME").as("END_TIME"),
                        DSL.field("MOVIE.LANGUAGE").as("LANGUAGE")
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

    public List<MovieShow> getShowsByMovieID(Long id, String showDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(showDate, dateTimeFormatter);
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        java.sql.Date nextSqlDate = java.sql.Date.valueOf(localDate.plusDays(1));

        SelectConditionStep conditionStep = this.getGenericQuery()
                .where(DSL.field("MOVIE.ID").eq(id)
                        .and(field("MOVIE_SHOWS.START_TIME").between(sqlDate).and(nextSqlDate)));
        List filteredMovieShows = conditionStep
                .fetch()
                .into(MovieShow.class);
        return filteredMovieShows;
    }
}
