package com.riad.learning.designPattern.strategy;

import java.util.Scanner;

public class TransportClient {

    public static void main(String[] args) {

        TransportContext tctx = new TransportContext();
        Scanner sc = new Scanner(System.in);
        System.out.println("0 = bus; 1 = OwnCar; 2 = Bike");

        if (sc.hasNextLine()){

            int value = Integer.parseInt(sc.nextLine());
            switch (value){
                case 0:
                    tctx.setTransport(new Bus());
                    break;
                case 1:
                    tctx.setTransport(new OwnCar());
                    break;
                case 2:
                    tctx.setTransport(new Bike());
                    break;
                default:
                    System.out.println("follow 0 = bus; 1 = OwnCar; 2 = Bike in next time");
                    break;
            }
            tctx.gotoDestinatiobBySelectedTransport();
        }
    }
}
