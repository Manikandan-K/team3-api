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

    public Movie(String name, String certification, String language, String synopsis, String genre, String crew, String movieCast, Integer runtime, String experiences, MovieListingType listingType) {
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

    public Movie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getMovieCast() {
        return movieCast;
    }

    public void setMovieCast(String movieCast) {
        this.movieCast = movieCast;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public void setListingType(MovieListingType listingType) {
        this.listingType = listingType;
    }

    public MovieListingType getListingType() {
        return listingType;
    }
}