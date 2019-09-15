package com.gojeck.parkinglot.business;

import com.gojeck.parkinglot.data.Car;

public interface ParkingLotService {
    int parkCar(Car c);

    void leaveCar(int slotNum);

    void getStatus();

    void getRegistrationNumberForGivenColor(String colour);

    void getSlotNumberForGivenColor(String colour);

    int getSlotNumberForGivenRegistrationNumber(String regNum);
}
