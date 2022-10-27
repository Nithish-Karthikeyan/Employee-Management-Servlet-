package com.ideas2it.model;

import java.util.List;

/**
 * This is the POJO class for employee project
 * Contains the setter and getter methods for employeeProject attributes
 *
 * @author Nithish K
 * @version 1.0
 * @since 19.09.2022
 */
public class EmployeeProject {
    private int projectId;
    private String employeeId;
    private String projectName;
    private String startDate;
    private String projectManagerName;
    private String clientName;
    private String createdAt;
    private String modifiedAt;
    private List<Employee> employees;

    public EmployeeProject() {}

    public EmployeeProject(String projectName, String projectManagerName, String clientName, String startDate, String createdAt, String modifiedAt) {
        this.projectName = projectName;
        this.projectManagerName = projectManagerName;
        this.clientName = clientName;
        this.startDate = startDate;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public EmployeeProject(String projectName, String projectManagerName, String clientName, String startDate) {
        this.projectName = projectName;
        this.projectManagerName = projectManagerName;
        this.clientName = clientName;
        this.startDate = startDate;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }
  
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }  

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProjectId() {
        return projectId;
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

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
   
    public List<Employee> getEmployees() {
        return employees;
    }

    public String toString() {
        String displayProjectInformation = "\nProject Id            : "+projectId+"\n"
                                            +"Project Manager       : "+projectManagerName+"\n"
                                            +"Project Name          : "+projectName+"\n"
                                            +"Client Name           : "+clientName+"\n"
                                            +"Project Start Date    : "+startDate+"\n";
        return displayProjectInformation;
        
    }
}