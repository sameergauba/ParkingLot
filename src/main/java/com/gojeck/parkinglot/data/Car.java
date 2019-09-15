package com.gojeck.parkinglot.data;

public class Car {
    private String registrationNumber;
    private String colour;

    public Car(String r, String c) {
        this.registrationNumber = r;
        this.colour = c;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColour() {
        return colour;
    }
}