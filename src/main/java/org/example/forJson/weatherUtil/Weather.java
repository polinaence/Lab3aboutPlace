package org.example.forJson.weatherUtil;

import java.util.List;

public class Weather {
    private  List<PlaceWeather> weather;

    public  List<PlaceWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<PlaceWeather> weather) {
        this.weather = weather;
    }

    public Weather(){

    }

    private PlaceTemp main;

    public PlaceTemp getMain() {
        return main;
    }

    public void setMain(PlaceTemp main) {
        this.main = main;
    }
}
