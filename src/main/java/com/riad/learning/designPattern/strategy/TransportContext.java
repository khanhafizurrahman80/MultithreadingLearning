package com.riad.learning.designPattern.strategy;

public class TransportContext {

    private Transport transport;

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public void gotoDestinatiobBySelectedTransport(){
        transport.gotoDestination();
    }
}
