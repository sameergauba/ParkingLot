package com.gojeck.parkinglot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.gojeck.parkinglot.business.impl.ParkingLotServiceImpl;
import com.gojeck.parkinglot.data.Car;
import com.gojeck.parkinglot.data.Commands;
import com.gojeck.parkinglot.business.ParkingLotService;

public class ParkingLotExecutor {
    private static ParkingLotService parkingLot = null;
    public static void main(String[] args) {
        try {
            readAndExecuteCommands(getScanner(args));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private static void readAndExecuteCommands(Scanner sc) {
        String line, command;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] commandLine = line.split(" ");
            command = commandLine[0];
            executeCommand(command, commandLine);
        }
    }

    private static void executeCommand(String command, String[] commandLine) {
        String regNo, color;
        int parkingSlot;
        switch (Commands.getCommand(command)) {
            case CREATE:
                int count = Integer.parseInt(commandLine[1]);
                parkingLot = new ParkingLotServiceImpl(count);
                System.out.println("Created a parking lot with " + count + " slots");
                break;
            case LEAVE:
                parkingSlot = Integer.parseInt(commandLine[1]);
                parkingLot.leaveCar(parkingSlot - 1);
                System.out.println("Slot number " + parkingSlot + " is free");
                break;
            case PARK:
                regNo = commandLine[1];
                color = commandLine[2];
                parkingSlot = parkingLot.parkCar(new Car(regNo, color));
                if (parkingSlot != -1) {
                    System.out.println("Allocated Slot Number: " + parkingSlot);
                } else
                    System.out.println("Sorry, parking lot is full");
                break;
            case REGISTRATION_NUMBERS:
                color = commandLine[1];
                parkingLot.getRegistrationNumberForGivenColor(color);
                break;
            case SLOT_COLOUR:
                color = commandLine[1];
                parkingLot.getSlotNumberForGivenColor(color);
                break;
            case SLOT_REGISTRATION:
                regNo = commandLine[1];
                parkingSlot = parkingLot.getSlotNumberForGivenRegistrationNumber(regNo);
                if (parkingSlot != -1) {
                    System.out.println(parkingSlot);
                } else
                    System.out.println("Not Found");
                break;
            case STATUS:
                parkingLot.getStatus();
                break;
            default:
                break;
        }
    }

    private static Scanner getScanner(String[] args) throws FileNotFoundException {
        Scanner sc;
        if (args.length > 0) {
            String fileName = args[0];
            File f = new File(fileName);
            sc = new Scanner(f);
        } else
            sc = new Scanner(System.in);
        return sc;
    }
}