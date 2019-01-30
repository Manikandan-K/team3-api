package spicinemas.api.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import spicinemas.api.type.MovieListingType;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Movie {
    private Long id;
    private String name;
    private String certification;
    private String language;
    private String synopsis;
    private String genre;
    private String crew;
    private String movieCast;
    private Integer runtime;
    private String experiences;
    private MovieListingType listingType;

    public Movie() {
    }

    public Movie(String name, String certification, String language,
                 String synopsis, String genre, String crew, String movieCast,
                 Integer runtime, String experiences, MovieListingType listingType) {
        this.name = name;
        this.certification = certification;

        this.language = language;
        this.synopsis = synopsis;
        this.genre = genre;
        this.crew = crew;
        this.movieCast = movieCast;
        this.runtime = runtime;
        this.experiences = experiences;
        this.listingType = listingType;
    }
}
