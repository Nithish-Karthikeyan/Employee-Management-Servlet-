package com.ideas2it.service;

import com.ideas2it.model.LeaveRecord;

import java.util.List;

/**
 * This is the interface for Leave Record Service  
 * This interface contains methods for handling employee leave Records
 *
 * @author Nithish K
 * @version 1.0
 * @since 19.09.2022
 */
public interface LeaveRecordService {

    /**
     * This method gets the input from the controller
     * and passes the leave record to the LeaveRecord Dao
     *
     * @param leaveRecord Get leave record from the controller
     * @return int
     */
    int addLeaveRecord(LeaveRecord leaveRecord);

    /**
     * Passes employee ID to LeaveRecord Dao to get leave records of particular employee
     * Custom exception is created when employee doesn't 
     * match with the id it shows employee not found exception
     *
     * @param employeeId Get employeeID from the controller
     * @return List<LeaveRecord>
     */
    List<LeaveRecord> getLeaveRecordByEmployeeId(String employeeId) ;

    /**
     * Calls the method in LeaveRecordDao to insert the updated value of leave record
     *
     * @param leaveEntry Get update leave record from the controller
     * @return boolean 
     */
    boolean updateLeaveRecord(LeaveRecord leaveEntry);

    /**
     * Passes the employee ID to Leave RecordDao which the user want to delete
     *
     * @param employeeId Get employeeID from the controller
     * @return int
     */
    int removeLeaveRecord(String employeeId);

    /**
     * Gets the entire leave Records from
     * the LeaveRecord Dao and passes to the controller
     *
     * @return List<LeaveRecord> 
     */
    List<LeaveRecord> getLeaveRecords();

}