package com.ideas2it.enums;

/**
 * Enums for selecting Leave Type
 * based on the userchoice gender is assigned
 */
public enum LeaveType {
    CASUAL_LEAVE("1"),
    SICK_LEAVE("2"),
    MEDICAL_LEAVE("3");

    private String value;

    LeaveType(String value) {
        this.value = value;
    }
   
    public static LeaveType getLeaveType(String index) {
        LeaveType choice = null;
        for (LeaveType leaveType : LeaveType.values()) {
            if (leaveType.value.equals(index)) {
                choice = leaveType;
            }
        }
        return choice;
    }

}