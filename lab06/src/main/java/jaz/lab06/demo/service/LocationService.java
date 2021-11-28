package jaz.lab06.demo.service;


import jaz.lab06.demo.location.Location;
import jaz.lab06.demo.DataProvider.ApiDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LocationService {
    LocationsDataRepository locationsDataRepository;

    @Autowired
    public LocationService(LocationsDataRepository locationsDataRepository) {
        this.locationsDataRepository = locationsDataRepository;
    }

    public void addNewLocations(Location location) throws IOException {
        locationsDataRepository.save(location);
        new ApiDataProvider().createSpecifiedAndValidateLocation(location);

    }
}
