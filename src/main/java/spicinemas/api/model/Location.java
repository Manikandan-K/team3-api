package spicinemas.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(exclude = {"id"})
public class Location {
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public Location() {}

    public Location(String name) {
        this.name = name;
    }
}
