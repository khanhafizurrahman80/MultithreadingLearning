package com.riad.learning.designPattern.strategy;

import java.util.Scanner;

public class TransportClient {

    public static void main(String[] args) {

        TransportContext tctx = new TransportContext();
        Scanner sc = new Scanner(System.in);
        System.out.println("0 = bus; 1 = OwnCar; 2 = Bike");

        if (sc.hasNextLine()){

            int value = Integer.parseInt(sc.nextLine());
            tctx.setTransport(value);
            tctx.gotoDestinatiobBySelectedTransport();
        }
    }
}
