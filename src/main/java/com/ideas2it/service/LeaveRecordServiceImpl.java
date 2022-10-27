package com.ideas2it.service;

import com.ideas2it.dao.LeaveRecordDao;
import com.ideas2it.dao.LeaveRecordDaoImpl;
import com.ideas2it.model.LeaveRecord;

import java.util.List;

/**
 * This class implements the Leave Record Service  
 * Contains methods for handling employee leave Records
 *
 * @author Nithish K
 * @version 1.0
 * @since 19.09.2022
 */
public class LeaveRecordServiceImpl implements LeaveRecordService {

    private final LeaveRecordDao leaveRecordDaoImpl = new LeaveRecordDaoImpl();
    
    @Override 
    public int addLeaveRecord(LeaveRecord leaveRecord) {
        return leaveRecordDaoImpl.addLeaveRecord(leaveRecord);
    }

    @Override
    public List<LeaveRecord> getLeaveRecordByEmployeeId(String employeeId) {
	return leaveRecordDaoImpl.getLeaveRecordByEmployeeId(employeeId);
    }

    @Override
    public boolean updateLeaveRecord(LeaveRecord leaveEntry) {
        return leaveRecordDaoImpl.updateLeaveRecord(leaveEntry);
    } 

    @Override
    public List<LeaveRecord> getLeaveRecords() {
        return leaveRecordDaoImpl.getLeaveRecords();
    }

    @Override
    public int removeLeaveRecord(String employeeId) {
        return leaveRecordDaoImpl.removeLeaveRecord(employeeId);
    }

}