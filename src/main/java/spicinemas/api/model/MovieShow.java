package spicinemas.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
}
