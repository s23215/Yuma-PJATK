package jaz.lab06.demo.DataProvider;

import jaz.lab06.demo.location.Location;
import jaz.lab06.demo.location.SpecifiedLocation;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiDataProvider {

    public void createSpecifiedAndValidateLocation(Location location) throws IOException {
        URL url = new URL(giveMeUrl(location));
        String json = returnJson(url);
        createValidateLocation(json);
    }

    public void createValidateLocation(String s){
        JSONObject json = new JSONObject(s);
        JSONObject result = (JSONObject) json.getJSONArray("results").get(0);

        JSONObject formattedAddress = result.getJSONObject("formatted_address");
        System.out.println(formattedAddress);

        JSONObject geometry = result.getJSONObject("geometry");
        JSONObject coords = geometry.getJSONObject("location");
        double lat = coords.getDouble("lat");
        double lng = coords.getDouble("lng");
    }

    private String returnJson(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        Scanner scanner = new Scanner(url.openStream());
        StringBuilder inline = new StringBuilder();
        while (scanner.hasNext()) {
            inline.append(scanner.nextLine());
        }
        scanner.close();
        return inline.toString();
    }

    private String giveMeUrl(Location location) {
        return "https://maps.googleapis.com/maps/api/geocode/json?address="
                + location.getStreetNumber() + "+"
                + location.getStreet().replaceAll(" ", "") + "+"
                + location.getCity().replaceAll(" ", "") + "+"
                + location.getPostalCode().replaceAll("-", "")
                + "&key=AIzaSyACqO4NpC-0yx0Sn2j1b_nxr8gBNDlCPhU";
    }
}
