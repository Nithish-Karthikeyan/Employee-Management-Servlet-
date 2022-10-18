package com.ideas2it.datetimeutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.Calendar;


/**
 * This class is for Date Time Calculation 
 * Perform Date validaiton, Age calulation and get current time
 *
 * @author Nithish K
 * @version 1.0
 * @since 19.09.2022
 */ 
public class DateTimeUtils {
    private final static int MINIMUM_AGE = 17;
    private final static int MAXIMUM_AGE = 70;

    /**
     * Validates the date of Birth
     * the input will be obtained from validation util class
     * catch block will catch the parse exception if it occurs
     *
     * @param dateOfBirth
     * @return boolean This returns true or false
     */
    public boolean validateDateOfBirth(String dateOfBirth) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();

        try {
            dateFormat.setLenient(false);
            Date birthDate = dateFormat.parse(dateOfBirth);
            calendar.setTime(birthDate);
            Calendar currentDate = Calendar.getInstance();

            int age = currentDate.get(Calendar.YEAR) - calendar.get(Calendar.YEAR); 
            if(age > MINIMUM_AGE && age < MAXIMUM_AGE) {
                return true;
            } else { 
                System.out.println("Invalid age, the age should be between 18 and 70");
                return false;
            }
        } catch (ParseException e) {
            System.out.println("Invalid Format, enter in format dd-mm-yyyy");
            return false;
        }
    }

    /**
     * Validate the dates obtained from the validation util class
     *
     * @param dateToCheck
     * @return boolean
     */
    public boolean validateDate(String dateToCheck) {
        boolean isValidDate = false;
        try {
            LocalDate date = LocalDate.parse(dateToCheck);
            isValidDate = true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid Date format:yyyy-mm-dd");
        }    
        return isValidDate;
    }

    /**
     * Get the current date and time
     *
     * @return current_date 
     */
    public String getDate() {
        String current_date = null;
        String dateFormat= "yyyy-MM-dd HH:mm:ss";
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
        current_date = date.format(dateFormatter);
        return current_date;
    }

    /**
     * Gets the difference between two dates
     *
     * @param fromDate
     * @param toDate
     * @return count - returns the leave count
     */
    public int findLeaveCount(LocalDate  fromDate, LocalDate toDate) { 
        int leaveCount = 0;  
        Period difference = Period.between(fromDate, toDate); 
        leaveCount = difference.getDays();
        return leaveCount;
    }

    /**
     * Parse the String to localdate format
     *
     * @return localDateFormat 
     */
    public LocalDate getLocalDateFormat(String date) {
        LocalDate localDateFormat = LocalDate.parse(date);
        return localDateFormat;
    }   
}