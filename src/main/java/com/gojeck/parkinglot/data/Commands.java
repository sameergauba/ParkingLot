package com.gojeck.parkinglot.data;

public enum Commands {

    CREATE("create_parking_lot"), PARK("park"), LEAVE("leave"), STATUS("status"), REGISTRATION_NUMBERS("registration_numbers_for_cars_with_colour"),
    SLOT_COLOUR("slot_numbers_for_cars_with_colour"), SLOT_REGISTRATION("slot_number_for_registration_number"), NO_COMMAND("");
    String command;

    Commands(String command) {
        this.command = command;
    }

    String getCommand(){
        return command;
    }

    public static Commands getCommand(String comm) {
        if (CREATE.getCommand().equals(comm))
            return CREATE;
        else if (PARK.getCommand().equals(comm))
            return PARK;
        else if (LEAVE.getCommand().equals(comm))
            return LEAVE;
        else if (STATUS.getCommand().equals(comm))
            return STATUS;
        else if (REGISTRATION_NUMBERS.getCommand().equals(comm))
            return REGISTRATION_NUMBERS;
        else if (SLOT_COLOUR.getCommand().equals(comm))
            return SLOT_COLOUR;
        else if (SLOT_REGISTRATION.getCommand().equals(comm))
            return SLOT_REGISTRATION;
        else
            return  NO_COMMAND;

    }
}