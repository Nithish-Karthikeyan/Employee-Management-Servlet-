package com.ideas2it.service;

import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dao.EmployeeDaoImpl;
import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeProject;
import org.hibernate.HibernateException;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * This class implements Employee service interface 
 * It contains methods for manipulating employee details
 *
 * @author Nithish K
 * @verison 1.0
 * @since 14.09.2022
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();
    
    @Override 
    public String addEmployee(Employee employee) {
        return employeeDaoImpl.addEmployee(employee);
    }


    @Override 
    public String createEmployeeId() {
        return employeeDaoImpl.generateEmployeeId();
    }

    @Override
    public Employee getEmployeeById(String id) throws HibernateException, NoResultException {
	return employeeDaoImpl.getEmployeeById(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeDaoImpl.updateEmployee(employee);
    } 

    @Override
    public int removeEmployee(String employeeId) {  
        return employeeDaoImpl.removeEmployee(employeeId);              
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDaoImpl.getEmployees();
    }

    @Override
    public boolean assignProject(Employee employee, EmployeeProject project) {
        return employeeDaoImpl.assignProject(employee, project);
    }

    public List<Object[]> getEmployeeDetails(String employeeId) {
        return employeeDaoImpl.getEmployeeDetails(employeeId);
    }
}