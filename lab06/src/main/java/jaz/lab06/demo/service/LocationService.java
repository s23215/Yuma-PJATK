package jaz.lab06.demo.service;


import jaz.lab06.demo.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class LocationService {
    LocationsDataRepository locationsDataRepository;

    @Autowired
    public LocationService(LocationsDataRepository locationsDataRepository) {
        this.locationsDataRepository = locationsDataRepository;
    }

    public void addNewLocations(Location location) throws IOException {
        locationsDataRepository.save(location);
        convertJsonToJavaClass(location);
    }

    public String giveMeUrl(Location location) {
        return "https://maps.googleapis.com/maps/api/geocode/json?address="
                + location.getStreetNumber() + "+"
                + location.getStreet().replaceAll(" ","") + "+"
                + location.getCity().replaceAll(" ","") + "+"
                + location.getPostalCode().replaceAll("-","")
                + "&key=AIzaSyACqO4NpC-0yx0Sn2j1b_nxr8gBNDlCPhU";
    }

    private void convertJsonToJavaClass(Location location) throws IOException {
        URL url = new URL(giveMeUrl(location));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null){
            content.append(inputLine);
        }
        in.close();

        //System.out.println(content);
    }
}
