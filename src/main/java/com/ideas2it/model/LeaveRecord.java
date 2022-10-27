package com.ideas2it.model;

/**
 * This is the POJO class for leave record
 * Contains the setter and getter methods for leaveRecord attributes
 *
 * @author Nithish K
 * @version 1.0
 * @since 19.09.2022
 */
public class LeaveRecord {
    private int leaveId;
    private String employeeId;
    private String fromDate;
    private String toDate;
    private String leaveType;
    private String createdAt;
    private String modifiedAt;
    private int deleted;
    private Employee employee;

    public LeaveRecord() {}
    
    public LeaveRecord(Employee employee, String fromDate, String toDate, String leaveType, String createdAt, String modifiedAt) {
        this.employee = employee;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.leaveType = leaveType;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt; 
    }

    public LeaveRecord(String fromDate, String toDate, String leaveType) {
        this.fromDate = fromDate;
        this.toDate  = toDate;
        this.leaveType = leaveType;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveType() {
        return leaveType;
    } 

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
   
    public String getEmployeeId() {
        return employeeId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }
    public int getLeaveId() {
        return leaveId;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getCreatedAt() {
        return createdAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
    
    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getDeleted() {
        return deleted;
    }

    @Override
    public String toString() {
        String displayLeaveRecords = "\nLeave ID      : "+leaveId+"\n"
                                      +"From Date     : "+fromDate+"\n"
                                      +"To Date       : "+toDate+"\n"
                                      +"Leave Type    : "+leaveType+"\n";
        return displayLeaveRecords;
    }

}

 