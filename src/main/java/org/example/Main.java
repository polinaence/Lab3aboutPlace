package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;


public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException, URISyntaxException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи локацию :");

        String location = scanner.next();
        var getCords = new GetCords(location);
        getCords.getResponse().join();
        //sleep(3000);

        String tmp = scanner.next();
        Integer currLocation = Integer.parseInt(tmp)-1;

        //for (int i = 0; i < getCords.hits.size(); i++) {
        //    if(i!=currLocation){
       //         continue;
        //    }
       //     var hit = getCords.hits.get(i);
       //     System.out.println(hit.getPoint());
       // }
        var hit = getCords.hits.get(currLocation);

        double Lat = hit.getPoint().getLat();
        double Lon = hit.getPoint().getLng();

        var getWeather = new GetWeather(Lat,Lon);
        getWeather.getWResponse();
        sleep(20000);


    }
}