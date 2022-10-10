package org.example;

import org.example.getters.GetCords;

import org.example.getters.GetIntPlace;
import org.example.getters.GetWeather;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;


public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException, URISyntaxException {

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введи локацию :");

            String location = scanner.next();
            if (location.equals("exit")) {
                return;
            }
            var getCords = new GetCords(location);
            getCords.getResponse().join();
            if (getCords.hits.size() == 0) {
                System.out.println("Пожалуйста не пиши так :-( ");
                continue;
            }

            String tmp = scanner.next();
            Integer currLocation = Integer.parseInt(tmp) - 1;

            var hit = getCords.hits.get(currLocation);


            double Lat = hit.getPoint().getLat();
            double Lon = hit.getPoint().getLng();

            var getWeather = new GetWeather(Lat, Lon);
            getWeather.getWResponse();

            var getIntPlace = new GetIntPlace(Lat, Lon);
            getIntPlace.getIResponse().join();
            sleep(3000);


        }
    }

}