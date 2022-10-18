package com.ideas2it.exception;

/**
 * This class is for custom exception
 * Child class for Exception
 * Exception occurs whern employee not found in the database 
 *
 * @author Nithish K
 * @version 1.0
 * @since 19.09.2022
 */
public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException (String message) {
        super(message);
    }
}