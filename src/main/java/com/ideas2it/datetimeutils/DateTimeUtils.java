package com.ideas2it.datetimeutils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * This class is for Date Time Calculation 
 * Get current time
 *
 * @author Nithish K
 * @version 1.0
 * @since 19.09.2022
 */ 
public class DateTimeUtils {
    /**
     * Get the current date and time
     * @return current_date 
     */
    public String getDate() {
        String current_date;
        String dateFormat= "yyyy-MM-dd HH:mm:ss";
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
        current_date = date.format(dateFormatter);
        return current_date;
    }

    public boolean validateLeaveDate(String fromDate, String toDate) {
        boolean isValidDate = false;
        LocalDate startDate = LocalDate.parse(fromDate);
        LocalDate endDate = LocalDate.parse(toDate);
        int difference = startDate.compareTo(endDate);

        if (difference == 0) {
            isValidDate = true;
        } else if (difference < 0) {
            isValidDate = true;
        } else {
            isValidDate = false;
        }
        return isValidDate;
    }
}