package com.ideas2it.model;

import java.util.List;

/**
 * This is the POJO class for employee
 * Contains the setter and getter methods for employee attributes
 *
 * @author Nithish K
 * @version 1.0
 * @since 12.09.2022
 */
public class Employee {
    private String employeeId;
    private String employeeName;
    private String dateOfBirth;
    private String employeeGender;
    private String mobileNumber;
    private String emailId;
    private String employeeType;
    private String designation;
    private String createdAt;
    private String modifiedAt;
    private int deleted;
    private List<LeaveRecord> leaveRecords;
    private List<EmployeeProject> employeeProjects;
    
    public Employee () {}

    public Employee (String employeeId, String employeeType, String employeeName, String dateOfBirth, String employeeGender, 
                     String mobileNumber, String emailId, String designation, String createdAt, String modifiedAt) {
        this.employeeId = employeeId;
        this.employeeType = employeeType;
        this.employeeName = employeeName;
        this.employeeGender = employeeGender;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId; 
        this.designation = designation;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Employee(String employeeName, String employeeType, String employeeGender, String dateOfBirth, String mobileNumber, String emailId, String designation) {
        this.employeeName = employeeName;
        this.employeeType = employeeType;
        this.employeeGender = employeeGender;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.designation = designation;
    }


    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }


    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
 
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
  
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() { 
        return designation;
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

    public void setLeaveRecords(List<LeaveRecord> leaveRecords) {
        this.leaveRecords = leaveRecords;
    }

    public List<LeaveRecord> getLeaveRecords() {
        return leaveRecords;
    }

    public void setEmployeeProjects(List<EmployeeProject> employeeProjects) {
        this.employeeProjects = employeeProjects;
    }

    public List<EmployeeProject> getEmployeeProjects() {
        return employeeProjects;
    }

    @Override
    public String toString() {
        String displayEmployeeDetails = "\nEmployee ID              : "+employeeId+"\n"
                                         +"Employee Type            : "+employeeType+"\n"
                                         +"Employee Name            : "+employeeName+"\n"
                                         +"Employee Gender          : "+employeeGender+"\n"
                                         +"Employee Mobile Number   : "+mobileNumber+"\n"
                                         +"Employee Email Id        : "+emailId+"\n"
                                         +"Designation              : "+designation+"\n";
        return displayEmployeeDetails;
    } 
}
