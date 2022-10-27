package com.ideas2it.service;

import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeProject;
import org.hibernate.HibernateException;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * This is the interface for employee service 
 * This interface contains methods for manipulating employee details
 *
 * @author Nithish K
 * @version 1.0
 * @since 12.09.2022
 */
public interface EmployeeService {

    /**
     * This method gets the input from the controller
     * and passes the employee object to the Employee Dao
     *
     * @param employee Get the employee object from the controller
     * @return String
     */
    String addEmployee(Employee employee);

    /**
     * Passes the command to Employee Dao for generate 
     * a unique employee id 
     *
     * @return String - returns the id
     */
    String createEmployeeId();

    /**
     * Passes employee ID to EmployeeDao to get employee Details
     * Custom exception is created when employee doesn't 
     * match with the id it shows employee not found exception
     *
     * @param employeeId  Get employee Id from the controller
     * @return Employee
     */
    Employee getEmployeeById(String employeeId) throws HibernateException, NoResultException;

    /**
     * Calls the method in EmployeeDao to insert the updated value of Employee
     *
     * @param employee Get the updated employee object from the employee
     * @return boolean 
     */
    boolean updateEmployee(Employee employee);

    /**
     * Passes the employee ID to EmployeeDao which the user want to delete
     *
     * @param employeeId Get the employeeId from the controller
     * @return int
     */
    int removeEmployee(String employeeId);

    /**
     * Gets the entire employee list from
     * the Employee Dao and passes to the controller
     *
     * @return List<employees>
     */
    List<Employee> getEmployees();

    /**
     * Assign the employee to the project
     * @param employee Get Employee object form the controller
     * @param project  Get the employee project from the controller
     * @return boolean
     */
    boolean assignProject(Employee employee, EmployeeProject project);

    /**
     * Validates the email ID of the employee
     * If email ID is not exist it returns false
     * If email ID exists in the database it returns true
     * @param emailId get the emailID from the controller
     * @return boolean
     */
    boolean validateEmailId(String emailId);

    /**
     * Validates the mobile number of the employee
     * If mobile number is not exist it returns false
     * If mobile number exists in the database it returns true
     * @param mobileNumber get the mobile Number from the controller
     * @return boolean
     */
    boolean validateMobileNumber(String mobileNumber);
}