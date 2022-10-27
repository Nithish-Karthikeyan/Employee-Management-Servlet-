package com.ideas2it.dao;

import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeProject;
import org.hibernate.HibernateException;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * This is the interface for employee DAO 
 * This interface contains create, update, read and delete methods
 * This interface deals with the employee details
 *
 * @author Nithish K
 * @version 1.0
 * @since 14.09.2022
 */
public interface EmployeeDao {

    /**
     * Add a new employee to the data
     *
     * @param employee  - to add a new employee
     * @return String
     */
    String addEmployee(Employee employee);

    /**
     * Generate a unique id for the 
     * employee
     *
     * @return String id - returns the unique id
     */
    String generateEmployeeId();

    /**
     * Get the last employee ID from  the database
     *
     * @return String - returns the ID of the last employee
     */
    String getLastEmployeeId();

    /**
     * Get the employee details by using the employee ID
     *
     * @param employeeId Get employeeID from the employee service
     * @return Employee
     */
    Employee getEmployeeById(String employeeId) throws HibernateException, NoResultException;

    /**
     * Insert the updated details of the employee in the database
     *
     * @param employee Get employee object from the employee service
     * @return boolean 
     */
    boolean updateEmployee(Employee employee);

    /**
     * Delete the employee from the database
     * by using employeeId
     *
     * @param employeeId Get updated employee object from the employee service
     * @return int
     */
    int removeEmployee(String employeeId);
 
    /**
     * Get all the Employees list
     * from the data
     *
     * @return List<Employee> - returns the employee list  
     */
    List<Employee> getEmployees();

    /**
     * Assign employee to the project
     * @param employee Get employee object from the employee service
     * @param project Get project object from the employee project service
     * @return boolean
     */
    boolean assignProject(Employee employee, EmployeeProject project);

}
