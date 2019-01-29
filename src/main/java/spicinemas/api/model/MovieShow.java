package spicinemas.api.model;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.Date;

@Value
@EqualsAndHashCode(exclude = {"id"})
public class MovieShow {
    private Long id;
    private Long movieId;
    private Long theaterId;
    private Long soundSystemId;
    private Date startTime;
    private Date endTime;
}
