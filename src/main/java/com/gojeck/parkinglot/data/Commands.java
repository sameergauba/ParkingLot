package com.gojeck.parkinglot.data;

import com.gojeck.parkinglot.utils.ConstantsUtil;

public enum Commands {

    CREATE, PARK, LEAVE, STATUS, REGISTRATION_NUMBERS, SLOT_COLOUR, SLOT_REGISTRATION;

    public static Commands getCommand(String comm) {
        if (ConstantsUtil.CREATE.equals(comm))
            return CREATE;
        else if (ConstantsUtil.PARK.equals(comm))
            return PARK;
        else if (ConstantsUtil.LEAVE.equals(comm))
            return LEAVE;
        else if (ConstantsUtil.STATUS.equals(comm))
            return STATUS;
        else if (ConstantsUtil.REGISTRATION_NUMBERS.equals(comm))
            return REGISTRATION_NUMBERS;
        else if (ConstantsUtil.SLOT_COLOUR.equals(comm))
            return SLOT_COLOUR;
        else if (ConstantsUtil.SLOT_REGISTRATION.equals(comm))
            return SLOT_REGISTRATION;
        else
            return null;

    }
}