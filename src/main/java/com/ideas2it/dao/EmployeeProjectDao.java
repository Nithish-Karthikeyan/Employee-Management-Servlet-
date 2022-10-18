package com.ideas2it.dao;

import com.ideas2it.model.EmployeeProject;

import java.util.List;

/**
 * This is the interface for employee Project DAO 
 * This interface contains create and display methods
 * This interface deals with the employee project data
 *
 * @author Nithish K
 * @verison 1.0
 * @since 17.09.2022
 */
public interface EmployeeProjectDao {

    /**
     * Add project details of the employee to the data
     *
     * @param employeeProject  - to add project details of employee
     * @return boolean
     */
    int addEmployeeProject(EmployeeProject employeeProject);

    /**
     * Get the employee project details by using the employee ID
     * Custom exception is created when employee doesn't 
     * match with the id it shows employee project details not found exception
     *
     *@param employeeId
     *@return EmployeeProject
     */
    List<EmployeeProject> getEmployeeProjectByEmployeeId(String employeeId);

    /**
     * Get all the employee project list
     * from the data
     *
     * @return List<EmployeeProject> - returns the employee project list  
     */
    List<EmployeeProject> getEmployeeProjects();

    /**
     * Insert the updated details of the employeeProject in the database
     *
     * @param employeeProject
     * @return boolean 
     */
    boolean updateEmployeeProject(EmployeeProject employeeProject);

}