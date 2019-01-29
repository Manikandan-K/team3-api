package spicinemas.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

@Getter
@EqualsAndHashCode(exclude = {"id"})
public class Location {
    private Long id;
    private String name;

    public Location(){

    }

    public Location(String name){
       this.name = name;
    }
}
