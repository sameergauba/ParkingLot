package com.gojeck.parkinglot.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import com.gojeck.parkinglot.data.Car;
import com.gojeck.parkinglot.business.ParkingLotService;
import com.gojeck.parkinglot.utils.PrintUtil;

public class ParkingLotServiceImpl implements ParkingLotService {
    private int capacity;
    private HashMap<Integer, Car> parkingLot;
    private TreeSet<Integer> freeSlots;

    public ParkingLotServiceImpl(int capacity) {
        this.capacity = capacity;
        parkingLot = new HashMap<Integer, Car>();
        freeSlots = new TreeSet<Integer>();
        for (int i = 0; i < capacity; i++) {
            parkingLot.put(i, null);
            freeSlots.add(i);
        }
    }

    public int parkCar(Car c) {
        int nextAvailableSlot;
        if (freeSlots.isEmpty()) {
            return -1;
        } else {
            nextAvailableSlot = freeSlots.first();
            parkingLot.put(nextAvailableSlot, c);
            freeSlots.remove(nextAvailableSlot);
        }
        return (nextAvailableSlot + 1);
    }

    public void leaveCar(int slotNumber) {
        freeSlots.add(slotNumber);
        parkingLot.put(slotNumber, null);
    }

    public void getStatus() {
        System.out.println("Slot No\tRegistration No\tColour");
        for (int i = 0; i < capacity; i++) {
            Car car = parkingLot.get(i);
            if (car != null) {
                System.out.println(i + 1 + "\t" + car.getRegistrationNumber() + "\t" + car.getColour());
            }
        }
    }

    public void getRegistrationNumberForGivenColor(String colour) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < capacity; i++) {
            Car car = parkingLot.get(i);
            if (car != null && colour.equals(car.getColour())) {
                res.add(car.getRegistrationNumber());
            }
        }
        PrintUtil.printStringList(res);
    }

    public void getSlotNumberForGivenColor(String colour) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < capacity; i++) {
            Car car = parkingLot.get(i);
            if (car != null && colour.equals(car.getColour())) {
                res.add(i + 1);
            }
        }
        PrintUtil.printIntegerList(res);
    }

    public int getSlotNumberForGivenRegistrationNumber(String regNum) {
        int res = -1;
        for (int i = 0; i < capacity; i++) {
            Car car = parkingLot.get(i);
            if (car != null && regNum.equals(car.getRegistrationNumber())) {
                res = i + 1;
            }
        }
        return res;
    }
}