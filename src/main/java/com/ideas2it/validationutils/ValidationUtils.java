package com.ideas2it.validationutils;

import com.ideas2it.datetimeutils.DateTimeUtils;

import java.util.regex.Pattern;

/**
 * This validation class validates the user input
 * 
 * @author Nithish K
 * @version 1.0
 * @since 14.09.2022
 */
public class ValidationUtils {

    /**
     * Validates the name of the employee using regex,
     * the input will be obtained from controller class
     *
     * @param name
     * @return boolean This returns true or false
     *
     */
    public boolean validateName(String name) {
        return Pattern.matches("([a-zA-Z]{1,10}[\s.]?([a-zA-Z]{1,20}[\s.]?)+)", name);
    }
 
    /**
     * Validates the mobile number of the employee using regex,
     * the input will be obtained from controller class
     *
     * @param mobileNumber
     * @return boolean This returns true or false
     *
     */
    public boolean validateMobile(String mobileNumber) {
        return Pattern.matches("^[6789]{1}[0-9]{9}", mobileNumber);
    }

    /**
     * Validates the Email of the employee using regex,
     * the input will be obtained from controller class
     *
     * @param email
     * @return boolean This returns true or false
     *
     */
    public boolean validateEmail(String email) {
        return Pattern.matches("(^([a-z0-9_.-]{3,})+@([a-z0-9_.-]+)+[a-z.]{2,}$)", email);
    }

    /**
     * Validates the designation using regex,
     * the input will be obtained from controller class
     *
     * @param designation
     * @return boolean This returns true or false
     *
     */
    public boolean validateDesignation(String designation) {
        return Pattern.matches("([a-zA-Z]{1,10}[\s.]?([a-zA-Z]{1,20}[\s.]?)+)", designation);
    }
   
    /**
     * Validates the date of Birth
     * the input will be obtained from controller class
     * catch block will catch the parse exception if it occurs
     *
     * @param dateOfBirth
     * @return boolean This returns true or false
     *
     */
    public boolean validateDateOfBirth(String dateOfBirth) {    
        DateTimeUtils dateTimeUtils = new DateTimeUtils();
        return dateTimeUtils.validateDateOfBirth(dateOfBirth);
    }

    /**
     * Validate the dates obtained from the controller class
     *
     * @param date
     * @return boolean
     */
    public boolean validateDate(String date) {
        DateTimeUtils dateTimeUtils = new DateTimeUtils();
        return dateTimeUtils.validateDate(date);
    }

}
