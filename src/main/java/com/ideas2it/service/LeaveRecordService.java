package com.ideas2it.service;

import com.ideas2it.model.LeaveRecord;

import java.util.List;

/**
 * This is the interface for Leave Record Service  
 * This interface contains methods for handling employee leave Records
 *
 * @author Nithish K
 * @verison 1.0
 * @since 19.09.2022
 */
public interface LeaveRecordService {

    /**
     * This method gets the input from the controller
     * and passes the leave record to the LeaveRecord Dao
     *
     * @param leaveRecord
     * @return boolean
     */
    public int addLeaveRecord(LeaveRecord leaveRecord);

    /**
     * Passes employee ID to LeaveRecord Dao to get leave records of particular employee
     * Custom exception is created when employee doesn't 
     * match with the id it shows employee not found exception
     *
     * @param id
     * @return List<LeaveRecord>
     */
    public List<LeaveRecord> getLeaveRecordByEmployeeId(String id) ;

    /**
     * Calls the method in LeaveRecordDao to insert the updated value of leave record
     *
     * @param leaveEntry
     * @return boolean 
     */
    public boolean updateLeaveRecord(LeaveRecord leaveEntry);

    /**
     * Passes the employee Id to LeavaRecordDao which the user want to delete 
     *
     * @param employeeId
     * @return boolean
     */
    public int removeLeaveRecord(String employeeId);

    /**
     * Gets the entire leave Records from
     * the LeaveRecord Dao and passes to the controller
     *
     * @return List<LeaveRecord> 
     */
    public List<LeaveRecord> getLeaveRecords();

}