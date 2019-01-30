package spicinemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.db.LocationRepository;
import spicinemas.api.model.Location;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping(value = "/locations")
    public List<Location> getLocations() {
        return locationRepository.getAllLocations();
    }
}
