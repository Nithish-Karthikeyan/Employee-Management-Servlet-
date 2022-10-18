package com.ideas2it.enums;

/**
 * Employee Type that are available
 * for an employee
 * based on the userchoice employee type is assigned
 */
public enum EmployeeType {
    TRAINER("1"),
    TRAINEE("2");

    private String value;

    EmployeeType(String value) {
        this.value = value;
    }

    public static EmployeeType getEmployeeType(String index) {
        EmployeeType choice = null;
        for (EmployeeType employeeType : EmployeeType.values()) {
            if(index.equals(employeeType.value)) {
                choice = employeeType;
            }
        }        
        return choice;
    }
}