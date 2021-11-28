package jaz.lab06.demo.location;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}