package org.example.forJson.weatherUtil;

public class PlaceWeather {
    public PlaceWeather() {

    }

    private String main;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}
