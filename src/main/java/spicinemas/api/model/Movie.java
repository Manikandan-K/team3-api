package spicinemas.api.model;

import lombok.EqualsAndHashCode;
import spicinemas.api.type.MovieListingType;

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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCertification() {
        return certification;
    }

    public String getLanguage() {
        return language;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getGenre() {
        return genre;
    }

    public String getCrew() {
        return crew;
    }

    public String getMovieCast() {
        return movieCast;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public String getExperiences() {
        return experiences;
    }

    public MovieListingType getListingType() {
        return listingType;
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
