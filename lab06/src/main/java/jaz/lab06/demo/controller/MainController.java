package jaz.lab06.demo.controller;

import jaz.lab06.demo.location.Location;
import jaz.lab06.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Controller
public class MainController{
    LocationService locationsService;

    @Autowired
    public MainController(LocationService locationService) {
        this.locationsService = locationService;
    }

    @PostMapping(path="/trace/calculate", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Location> addNewTrace(@RequestBody Location locationsData) throws IOException {
        locationsService.addNewLocations(locationsData);
        return new ResponseEntity<>(locationsData, HttpStatus.OK);
    }
}