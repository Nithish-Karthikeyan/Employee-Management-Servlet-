package com.ideas2it.enums;

/**
 * Enums for selecting gender
 * based on the userchoice gender is assigned
 */
public enum Gender {
    MALE("1"),
    FEMALE("2"),
    OTHER ("3");

    private String value;

    Gender(String value) {
        this.value = value;
    }
  
    public static Gender getEmployeeGender(String index) {
        Gender gender = null;

        for (Gender choice: Gender.values()) {
            if(choice.value.equals(index)) {
                gender = choice;
            }
        }        
        return gender;
    }
}