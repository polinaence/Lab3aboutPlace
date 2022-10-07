package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.forJson.intPlace.NearBy;
import org.example.forJson.intPlace.Properties;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.net.http.HttpRequest.newBuilder;

public class GetIntPlace {
    private static final String Key = "5ae2e3f221c38a28845f05b64e2e26237a7e7d529809cf323df46cb5";
    private double lat;
    private double lon;

    public GetIntPlace(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public CompletableFuture<Void> getIResponse() throws URISyntaxException {
        var client = HttpClient.newHttpClient();
        Integer RADIUS = 25000;

        HttpRequest request = newBuilder()
                .uri(new URI("https://api.opentripmap.com/0.1/en/places/radius?radius=" + RADIUS +
                        "&lon=" + this.lon +
                        "&lat=" + this.lat +
                        "&apikey=" + Key))
                .GET()
                .build();
        System.out.println("https://api.opentripmap.com/0.1/en/places/radius?radius=" + RADIUS +
                "&lon=" + this.lon +
                "&lat=" + this.lat +
                "&apikey=" + Key);
        return HttpClient.newBuilder()
                .build()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body).thenApply(placeInt -> {
                    try {
                        return CustomRarserIntPlace.PlaceIntr(placeInt);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .thenAccept(body -> {
                    Integer i = 0;
                    for (Properties feature : body.getFeatures()) {
                        if (feature.getProperties().getName()==null) {
                            i++;
                            System.out.println((i + 1) + ". " + feature.getProperties().getName()+ " " + feature.getProperties().getXid());
                            if (i==5){
                                break;
                            }
                        }
                    }

                })
                ;
    }

}
