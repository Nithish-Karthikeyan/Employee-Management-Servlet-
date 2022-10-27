package com.ideas2it.dao;

import com.ideas2it.model.LeaveRecord;

import java.util.List;

/**
 * This is the interface for Leave Record of employees 
 * Contains create, update and read methods
 * Deals with the employee leave Record
 *
 * @author Nithish K
 * @version 1.0
 * @since 19.09.2022
 */
public interface LeaveRecordDao {

    /**
     * Add a new leave Record to the data
     *
     * @param leaveRecord  - to add a new leaveRecord
     * @return int
     */
    int addLeaveRecord(LeaveRecord leaveRecord);

    /**
     * Get the leave records of the employee by using the employee ID
     * Custom exception is created when employee doesn't 
     * match with the id it shows employee not found exception
     *
     *@param employeeId Get employeeId
     *@return List<LeaveRecord> 
     */
    List<LeaveRecord> getLeaveRecordByEmployeeId(String employeeId);

    /**
     *Insert the updated details of the leave Record in the database
     *
     *@param leaveEntry Get the updated leave record object from the leave record service
     *@return boolean 
     */
    boolean updateLeaveRecord(LeaveRecord leaveEntry);

    /**
     * Get all the leave records of the employees
     * from the data
     *
     * @return List<LeaveRecord> - returns the leave record list  
     */
    List<LeaveRecord> getLeaveRecords();

    /**
     * Delete the employee leave record from the database
     * by using employeeId
     *
     * @param employeeId Get employeeId from the leave record service
     * @return int
     */
    int removeLeaveRecord(String employeeId);

}