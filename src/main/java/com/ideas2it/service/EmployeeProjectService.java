package com.ideas2it.service;

import com.ideas2it.model.EmployeeProject;

import java.util.List;

/**
 * This is the interface for employee project service 
 * This interface contains methods for handling employee details
 *
 * @author Nithish K
 * @version 1.0
 * @since 19.09.2022
 */
public interface EmployeeProjectService {

    /**
     * This method gets the input from the controller
     * and passes the employee object to the Employee Project Dao
     *
     * @param employeeProject get employee project object from the controller
     * @return int
     */
    int addEmployeeProject(EmployeeProject employeeProject);

    /**
     * Passes employee ID to EmployeeProjectDao to get Project details of particular employee
     * Custom exception is created when employee doesn't 
     * match with the id it shows employee not found exception
     *
     *@param employeeId Get employeeId form the controller
     *@return List of employee projects
     */
    List<EmployeeProject> getEmployeeProjectByEmployeeId(String employeeId);

    /**
     * Gets the entire employee project list from
     * the Employee Project Dao and passes to the controller
     *
     * @return List<EmployeeProject>
     */
    List<EmployeeProject> getEmployeeProjects();

    /**
     * Calls the method in LeaveRecordDao to insert the updated value of LeaveRecord
     *
     * @param employeeProject Get update employeeProject object from the controller
     * @return boolean 
     */
    boolean updateEmployeeProject(EmployeeProject employeeProject);

}