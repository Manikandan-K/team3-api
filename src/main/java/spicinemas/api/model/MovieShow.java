package spicinemas.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.Date;

@Value
@EqualsAndHashCode(exclude = {"id"})
public class MovieShow {
    @JsonIgnore
    private long id;
    private String movieName;
    private String theaterName;
    private long theaterCapacity;
    private String experience;
    private long runtime;
    private Date startTime;
    private Date endTime;
    private String language;
    private long availableTickets;

    public MovieShow(long id, String movieName, String theaterName, long theaterCapacity, String experience, long runtime, Date startTime, Date endTime) {
        this.id = id;
        this.movieName = movieName;
        this.theaterName = theaterName;
        this.theaterCapacity = theaterCapacity;
        this.experience = experience;
        this.runtime = runtime;
        this.startTime = startTime;
        this.endTime = endTime;
        language = "";
        availableTickets = 0;
    }

    public MovieShow(long id, String movieName, String theaterName, long theaterCapacity, String experience, long runtime, Date startTime, Date endTime, String language) {
        this.id = id;
        this.movieName = movieName;
        this.theaterName = theaterName;
        this.theaterCapacity = theaterCapacity;
        this.experience = experience;
        this.runtime = runtime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.language = language;
        availableTickets = 0;
    }

    public MovieShow(long id, String movieName, String theaterName, long theaterCapacity, String experience, long runtime, Date startTime, Date endTime, String language, long availableTickets) {
        this.id = id;
        this.movieName = movieName;
        this.theaterName = theaterName;
        this.theaterCapacity = theaterCapacity;
        this.experience = experience;
        this.runtime = runtime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.language = language;
        this.availableTickets = availableTickets;
    }
}
