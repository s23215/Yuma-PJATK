package jaz.lab06.demo.location;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpecifiedLocation {

    @JsonProperty("lat")
    private int lat;

    @JsonProperty("ing")
    private int ing;

    @JsonProperty("StreetNumber")
    private int streetNumber;

    @JsonProperty("Street")
    private String street;

    @JsonProperty("PostalCode")
    private String postalCode;

    @JsonProperty("City")
    private String city;

    @JsonProperty("IsNormalized")
    private boolean isNormalised;

    @JsonProperty("OpenTime")
    private String openTime;

    @JsonProperty("CloseTime")
    private String closeTime;


    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getIng() {
        return ing;
    }

    public void setIng(int ing) {
        this.ing = ing;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isNormalised() {
        return isNormalised;
    }

    public void setNormalised(boolean normalised) {
        isNormalised = normalised;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }
}
