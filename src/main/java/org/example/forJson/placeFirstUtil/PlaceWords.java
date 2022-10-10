package org.example.forJson.placeFirstUtil;

import org.example.forJson.placeFirstUtil.PlaceLatLng;

public class PlaceWords {


    public PlaceWords() {

    }

    private String country;

    public PlaceLatLng getPoint() {
        return point;
    }

    public void setPoint(PlaceLatLng point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String city;

    private String name;

    private PlaceLatLng point;
}
