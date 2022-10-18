package com.ideas2it.controller;

import com.ideas2it.datetimeutils.DateTimeUtils;
import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeProject;
import com.ideas2it.model.LeaveRecord;
import com.ideas2it.service.*;
import org.hibernate.HibernateException;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is the controller class which contains main method
 * This class gets input from the user and print the employee details
 * leave record and project details
 *
 * @author Nithish K
 * @version 1.0
 * @since 17.09.2022
 */
public class EmployeeController {

    private final EmployeeService employeeServiceImpl = new EmployeeServiceImpl();
    private final LeaveRecordService leaveRecordServiceImpl = new LeaveRecordServiceImpl();
    private final EmployeeProjectService employeeProjectServiceImpl = new EmployeeProjectServiceImpl();


    /**
     * Gets the employee details from the user.
     * This method invokes another method for creating employee id
     * Gets input for employee name, employee Type, dateOfBirth, mobile number
     * email-id, designation
     * Every parameter is validating by validation util class
     */
    public String addEmployee(Employee employee) {
        DateTimeUtils dateTimeUtils = new DateTimeUtils();
        String employeeId = employeeServiceImpl.createEmployeeId();
        String name = employee.getEmployeeName();
        String employeeType = employee.getEmployeeType();
        String employeeGender = employee.getEmployeeGender();
        String dateOfBirth = employee.getDateOfBirth();
        String mobileNumber = employee.getMobileNumber();
        String emailId = employee.getEmailId();
        String designation = employee.getDesignation();
        String createdAt = dateTimeUtils.getDate();
        String modifiedAt = dateTimeUtils.getDate();

        employee = new Employee(employeeId, employeeType,
                                         name, dateOfBirth, employeeGender,
                                         mobileNumber, emailId, designation, 
                                         createdAt, modifiedAt);
        return employeeServiceImpl.addEmployee(employee);
    }      

    /**
     * This method print the employee details
     */ 
    public List<Employee> printEmployees() {
        return employeeServiceImpl.getEmployees();
    }

    /**
     * Get the employee id from the user 
     */
    public Employee getEmployeeById(String employeeId) throws HibernateException, NoResultException {
        return employeeServiceImpl.getEmployeeById(employeeId);
    }

    /**
     * Request the update employee method in employee service
     * to update the employee
     * @param employee
     * @return
     */

    public boolean updateEmployee(Employee employee) {
        DateTimeUtils dateTimeUtils = new DateTimeUtils();
        employee.setModifiedAt(dateTimeUtils.getDate());
        return employeeServiceImpl.updateEmployee(employee);
    }
   

    /**
     * Gets the employee id which the user 
     * wants to remove from the data
      */
    public int deleteEmployee(String employeeId) {
        return employeeServiceImpl.removeEmployee(employeeId);
    }

    /**
     * Gets the leave records from the user
     * First thing it gets the employee id and validates
     * the employee is existed or not exist
     * If employee exist it 
     * Gets input for fromDate, toDate and leave type
     */
    public int addLeaveRecord(LeaveRecord leaveRecord, Employee employee) {
        final int MAXIMUM_LEAVE_COUNT = 10;
        final int EMPTY_ID = 0;

        DateTimeUtils dateTimeUtils = new DateTimeUtils();

        //int leaveCount = getEmployeeLeaveCount(employeeId);
        //System.out.println("You have "+ (MAXIMUM_LEAVE_COUNT - leaveCount)+" left");

        String fromDate = leaveRecord.getFromDate();
        String toDate = leaveRecord.getToDate();
        String leaveType = leaveRecord.getLeaveType();
        String createdAt = dateTimeUtils.getDate();
        String modifiedAt = dateTimeUtils.getDate();
        leaveRecord = new LeaveRecord(employee, fromDate, toDate, leaveType,
                                                      createdAt, modifiedAt);
        return leaveRecordServiceImpl.addLeaveRecord(leaveRecord);
    }

    /**
     * Get the number of leaves taken by the employee
     * It validates the employee by employee id
     * If employee exist leave swill be calculated
     * If employee does not exist it show employee not found exception
     *
     *//*
    public int getEmployeeLeaveCount(String employeeId) {
        List<LeaveRecord> leaveRecords = new ArrayList<LeaveRecord>();
        LocalDate firstDate = null;
        LocalDate secondDate = null;
        int leaveCount = 0;
        leaveRecords = leaveRecordServiceImpl.getLeaveRecordByEmployeeId(employeeId);

        DateTimeUtils dateTimeUtils = new DateTimeUtils();
        for (LeaveRecord leaveEntry :leaveRecords) {
            firstDate = dateTimeUtils.getLocalDateFormat(leaveEntry.getFromDate());
            secondDate = dateTimeUtils.getLocalDateFormat(leaveEntry.getToDate());
            int count = dateTimeUtils.findLeaveCount(firstDate, secondDate);
            leaveCount+=count; 
        }
        return leaveCount;
    }
*/

    /**
     * Print all the leave records of the employees
     */
    public List<LeaveRecord> printLeaveRecords() {
        return leaveRecordServiceImpl.getLeaveRecords();
    }

    /**
     * Print the leave Record by employee-Id
     * @param employeeId
     */
    public List<LeaveRecord> getLeaveRecordByEmployeeId(String employeeId) {
        return leaveRecordServiceImpl.getLeaveRecordByEmployeeId(employeeId);
    }

    public LeaveRecord getLeaveRecord(int leaveId, String employeeId) {
        LeaveRecord leaveRecord = null;
        List<LeaveRecord> leaveRecords = getLeaveRecordByEmployeeId(employeeId);

        for (LeaveRecord leaveEntry: leaveRecords) {
            if (leaveEntry.getLeaveId() == leaveId) {
                leaveRecord = leaveEntry;
                return leaveRecord;
            }
        }
        return null;
    }

    /**
     * Request the update employee leave record method in employee leave record service 
     * to update the leave record
     *
     * @param leaveRecord
     */
    public boolean updateLeaveRecord(LeaveRecord leaveRecord) {
        DateTimeUtils dateTimeUtils = new DateTimeUtils();
        leaveRecord.setModifiedAt(dateTimeUtils.getDate());
        return leaveRecordServiceImpl.updateLeaveRecord(leaveRecord);
    }

    /**
     * Gets the employee id which the user 
     * wants to remove the leave record the data
     */
    public int deleteLeaveRecord(String employeeId) {
        return leaveRecordServiceImpl.removeLeaveRecord(employeeId);
    }
/*------------------------Employee Project*----------------------------*/

    /**
     * Gets the employee project from the user
     * First thing it gets the employee id and validates
     * the employee is existed or not exist
     * If employee exist it 
     * Gets input for project name, project manager id and start date of project
     * @param project getting project object from the servlet
     */
    public int addEmployeeProject(EmployeeProject project,Employee employee) {
        DateTimeUtils dateTimeUtils = new DateTimeUtils();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        String projectManagerName = project.getProjectManagerName();
        String projectName = project.getProjectName();
        String clientName = project.getClientName();
        String startDate = project.getStartDate();
        String createdAt = dateTimeUtils.getDate();
        String modifiedAt = dateTimeUtils.getDate();
        EmployeeProject employeeProject = new EmployeeProject(projectName,
                                                              projectManagerName,
                                                              clientName,
                                                              startDate,
                                                              createdAt,
                                                              modifiedAt);

        employeeProject.setEmployees(employees);
        return employeeProjectServiceImpl.addEmployeeProject(employeeProject);
    }

    /**
     * Print all the employee projects of the employees
     */
    public List<EmployeeProject> printEmployeeProjects() {
        return employeeProjectServiceImpl.getEmployeeProjects();
    }

    /**
     * Print the Employee Project by employee_Id
     */
    public List<EmployeeProject> getEmployeeProjectByEmployeeId(String employeeId) {
        return employeeProjectServiceImpl.getEmployeeProjectByEmployeeId(employeeId);
    }

    /**
     * Request the update employee project method in employee project service 
     * to update the project details
     *
     * @param employeeProject
     */
    public boolean updateEmployeeProject(EmployeeProject employeeProject) {
        DateTimeUtils dateTimeUtils = new DateTimeUtils();
        employeeProject.setModifiedAt(dateTimeUtils.getDate());
        return employeeProjectServiceImpl.updateEmployeeProject(employeeProject);
    }

    public EmployeeProject getProjectById(int projectId) {
        EmployeeProject project = null;
        List<EmployeeProject> projects = employeeProjectServiceImpl.getEmployeeProjects();

        for(EmployeeProject projectById : projects) {
            if(projectId == projectById.getProjectId()) {
                project = projectById;
            }
        }
        return project;
    }

/*    public void assignProject() {
        if (employee != null) {
            printEmployeeProjects();
            System.out.println("Enter the project id for the employee");
            int projectId = scanner.nextInt();
            EmployeeProject project = getProjectById(projectId);

            if (project != null) {
                employeeServiceImpl.assignProject(employee, project);
            }
        }   
    }

    public void printAllEmployeeDetails() {
        System.out.println("Enter the employee ID");
        String employeeId = scanner.next();
        List<Object[]> employeeInformation = employeeServiceImpl.getEmployeeDetails(employeeId);

        for(Object[] employeeDetail : employeeInformation) {
            Employee employee = (Employee) employeeDetail[0];
            //LeaveRecord leaves = (LeaveRecord) employeeDetail[1];
            EmployeeProject project = (EmployeeProject) employeeDetail[1];
            System.out.println(employee);
            //System.out.println(leaves);
            System.out.println(project);
        }
    }*/
}