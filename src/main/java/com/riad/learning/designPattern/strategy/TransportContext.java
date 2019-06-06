package com.riad.learning.designPattern.strategy;

public class TransportContext {

    private Transport transport;

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(int value) {
        switch (value){
            case 0:
                this.transport = new Bus();
                break;
            case 1:
                this.transport = new OwnCar();
                break;
            case 2:
                this.transport = new Bike();
                break;
            default:
                System.out.println("follow 0 = bus; 1 = OwnCar; 2 = Bike in next time");
                break;
        }
    }

    public void gotoDestinatiobBySelectedTransport(){
        transport.gotoDestination();
    }
}
