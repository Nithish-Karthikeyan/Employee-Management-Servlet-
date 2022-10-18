package com.ideas2it.servlet;

import com.google.gson.Gson;
import com.ideas2it.controller.EmployeeController;
import com.ideas2it.model.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.NoResultException;
import java.io.IOException;
import java.util.List;

public class EmployeeServlet extends HttpServlet {
    private final EmployeeController employeeController = new EmployeeController();

    private final Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();

        switch (action) {
            case "/addEmployee":
                addEmployee(request, response);
                break;

            case "/updateEmployee":
                updateEmployee(request, response);
                break;
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("employeeId");
        Employee employee = employeeController.getEmployeeById(employeeId);
        String status;
        employee.setEmployeeName(request.getParameter("employeeName"));
        employee.setEmployeeType(request.getParameter("employeeType"));
        employee.setEmployeeGender(request.getParameter("gender"));
        employee.setDateOfBirth(request.getParameter("dateOfBirth"));
        employee.setMobileNumber(request.getParameter("mobileNumber"));
        employee.setEmailId(request.getParameter("emailId"));
        employee.setDesignation(request.getParameter("designation"));
        boolean isUpdated = employeeController.updateEmployee(employee);

        if (isUpdated) {
            status = "Employee updated successfully";
        } else {
            status = "Employee not updated";
        }
        request.setAttribute("status",status);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("performEmployeeUpdate.jsp");
        requestDispatcher.include(request, response);
    }

    public void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status;
        String name = request.getParameter("employeeName");
        String employeeType = request.getParameter("employeeType");
        String gender = request.getParameter("gender");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String mobileNumber = request.getParameter("mobileNumber");
        String emailId = request.getParameter("emailId");
        String designation = request.getParameter("designation");
        Employee employee = new Employee(name,employeeType,gender,dateOfBirth,mobileNumber,emailId,designation);
        String employeeId = employeeController.addEmployee(employee);

        if (employeeId != null) {
            status = "Employee created successfully with id :"+employeeId;
        } else {
            status = "Employee not created";
        }
        request.setAttribute("status",status);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("performAddEmployee.jsp");
        requestDispatcher.include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();

        switch (action) {
            case "/readEmployeeById":
                getEmployeeById(request, response);
                break;

            case "/readEmployee":
                getAllEmployees(request, response);
                break;

            case "/deleteEmployee":
                deleteEmployee(request, response);
                break;

            case "/getEmployee":
                getEmployee(request, response);
                break;
        }
    }

    private void getEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoResultException {
        try {
            String employeeId = request.getParameter("employeeId");
            Employee employee = employeeController.getEmployeeById(employeeId);
            if (employee != null) {
                request.setAttribute("employee", employee);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performEmployeeUpdate.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (NoResultException e) {
            request.setAttribute("employee",e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performUpdateEmployee.jsp");
            requestDispatcher.include(request, response);
        }
    }


    public void getEmployeeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, NoResultException, IOException {
        try {
            String employeeId = request.getParameter("employeeId");
            Employee employee = employeeController.getEmployeeById(employeeId);
            employee.setLeaveRecords(null);
            employee.setEmployeeProjects(null);
            String employeeById = this.gson.toJson(employee);
            request.setAttribute("employee", employeeById);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performReadEmployeeById.jsp");
            requestDispatcher.include(request, response);
        } catch (NoResultException e) {
            request.setAttribute("employee", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performReadEmployeeById.jsp");
            requestDispatcher.include(request, response);
        }
    }

    public void getAllEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeController.printEmployees();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("performReadAllEmployees.jsp");
        requestDispatcher.include(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("employeeId");
        String status;
        int updatedRow = employeeController.deleteEmployee(employeeId);

        if (updatedRow > 0) {
            status = "Employee Deleted Successfully";
        } else {
            status = "Employee not found";
        }
        request.setAttribute("status",status);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("performDeleteEmployee.jsp");
        requestDispatcher.include(request, response);
    }

}