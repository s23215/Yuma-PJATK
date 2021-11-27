package jaz.lab06.demo.service;


import jaz.lab06.demo.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationService {
    LocationsDataRepository locationsDataRepository;

    @Autowired
    public LocationService(LocationsDataRepository locationsDataRepository) {
        this.locationsDataRepository = locationsDataRepository;
    }

    public void addNewLocations(Location location){
        locationsDataRepository.save(location);
    }
}
