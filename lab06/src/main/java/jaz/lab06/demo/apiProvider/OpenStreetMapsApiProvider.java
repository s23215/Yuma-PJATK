package jaz.lab06.demo.apiProvider;


import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jaz.lab06.demo.location.Location;

import java.nio.file.Path;


@Controller
public class OpenStreetMapsApiProvider {

    private String postalCodeReformat(Location location) {
        return location.getPostalCode().replaceAll("-","");
    }


    private String createValidUrl(Location location){
        return "https://nominatim.openstreetmap.org/search?q="
                + location.getStreetNumber() + "+" +
                location.getStreet() + "+" +
                location.getCity() + ",+" +
                postalCodeReformat(location) +
                "&format=json&polygon=1&addressdetails=1";
    }


    @GetMapping(path="", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<JSONPObject> addNewTrace(@RequestBody JSONPObject jsObject) {
        return new ResponseEntity<>(jsObject, HttpStatus.OK);
    }
}
