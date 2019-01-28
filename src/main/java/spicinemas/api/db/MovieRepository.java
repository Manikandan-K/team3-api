package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Movie;

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
        )
                .values(
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
                )
                .execute();

    }

    public Movie getMovie(String name) {
        return dsl.select()
                .from(DSL.table("MOVIE"))
                .where(DSL.field("MOVIE.NAME").eq(name))
                .fetchOne()
                .into(Movie.class);
    }
}
