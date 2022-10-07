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
        var i = new GetCords(location).getResponse();
        sleep(20000);

    }
}
