package spicinemas.api.model;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(exclude = {"id"})
public class Theater {
    private Long id;
    private String name;
    private Long locationId;
    private Long capacity;
}
