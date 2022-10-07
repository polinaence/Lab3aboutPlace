package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.forJson.placeFirstUtil.PlaceWords;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static java.net.http.HttpRequest.newBuilder;

public class GetCords {
    private static final String Key = "0453f1cf-d1f0-40a4-b6a0-e4fb6fc39799";

    private final String location;

    public GetCords(String location) {
        this.location = location;

    }

    public ArrayList<PlaceWords> hits = new ArrayList<>();

    public CompletableFuture<Void> getResponse() throws IOException, URISyntaxException {
        var client = HttpClient.newHttpClient();
        HttpRequest request = newBuilder()
                .uri(new URI("https://graphhopper.com/api/1/geocode?q=" + this.location +
                        "&key=" + Key))
                .GET()
                .build();
        System.out.println("https://graphhopper.com/api/1/geocode?q=" + this.location +
                "&key=" + Key);
        //////////////////////////////////////////////
        return HttpClient.newBuilder()
                .build()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body).thenApply(placeStr -> {
                    try {
                        return CustomParserPlace.PlacePars(placeStr);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .thenAccept(body -> {
                    hits = body.getHits();
                    for (int i = 0; i < hits.size(); i++) {
                        var hit = hits.get(i);
                        System.out.println((i + 1) + ". " + hit.getName() + " " + hit.getCountry() + " " + hit.getCity());
                    }
                })
                ;
    }


}