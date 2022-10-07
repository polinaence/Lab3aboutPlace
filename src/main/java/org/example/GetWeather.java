package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.forJson.weatherUtil.PlaceWeather;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.net.http.HttpRequest.newBuilder;


public class GetWeather {
    private static final String Key = "a580120f3f184668be2bcee4aa803d6a";
    private double lat;
    private double lon;

    public GetWeather(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
    public List<PlaceWeather> weathers = new ArrayList<>();

    public CompletableFuture<Void> getWResponse() throws URISyntaxException {
        var client = HttpClient.newHttpClient();
        HttpRequest request = newBuilder()
                .uri(new URI("https://api.openweathermap.org/data/2.5/weather?lat=" + this.lat + "&lon=" + this.lon +
                        "&appid=" + Key))
                .GET()
                .build();
        System.out.println("https://api.openweathermap.org/data/2.5/weather?lat=" + this.lat + "&lon=" + this.lon +
                "&appid=" + Key);
        return HttpClient.newBuilder()
                .build()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body).thenApply(placeWeather -> {
                    try {
                        return CustomParserWeather.PlaceWeather(placeWeather);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
        .thenAccept(body -> {
            weathers = body.getWeather();
            System.out.println("Weather " + weathers.get(0).getMain() +"; Описание "+ weathers.get(0).getDescription() + "; Температура " + (body.getMain().getTemp() -273) + "; Филз Лайк " + (body.getMain().getFeels_like()-273));
        })
        ;
    }
}

