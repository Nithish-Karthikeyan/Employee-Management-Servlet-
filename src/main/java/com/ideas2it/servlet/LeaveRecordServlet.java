package com.ideas2it.servlet;

import com.ideas2it.controller.EmployeeController;
import com.ideas2it.model.Employee;
import com.ideas2it.model.LeaveRecord;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.NoResultException;
import java.io.IOException;
import java.util.List;

public class LeaveRecordServlet extends HttpServlet {
    private final EmployeeController employeeController = new EmployeeController();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();

        switch (action) {
            case "/addLeaveRecord":
                addLeaveRecord(request, response);
                break;

            case "/updateLeaveRecord":
                updateLeaveRecord(request, response);
                break;
        }
    }

    public void addLeaveRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = employeeController.getEmployeeById(request.getParameter("employeeId"));
        String status;
        String fromDate = request.getParameter("fromDate");
        String toDate = request.getParameter("toDate");
        String leaveType = request.getParameter("leaveType");
        LeaveRecord leaveRecord = new LeaveRecord(fromDate,toDate,leaveType);
        int leaveId = employeeController.addLeaveRecord(leaveRecord,employee);

        if (leaveId > 0)
            status = "Leave Record created";
        else
            status = "Leave Record not created";
        request.setAttribute("status",status);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("performAddLeaveRecord.jsp");
        requestDispatcher.include(request, response);
    }

    public void getLeaveRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoResultException {
        String employeeId = request.getParameter("employeeId");
        int id = Integer.parseInt(request.getParameter("leaveId"));
        try {
            LeaveRecord leaveRecord = employeeController.getLeaveRecord(id, employeeId);
            if (leaveRecord != null) {
                request.setAttribute("employee",employeeId);
                request.setAttribute("leaveRecord", leaveRecord);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performUpdateLeaveRecord.jsp");
                requestDispatcher.forward(request, response);
            } else {
                request.setAttribute("leaveRecord", "No leaves found");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performEditLeaveRecord.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("leaveRecord", "Invalid Leave ID");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performEditLeaveRecord.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    public void updateLeaveRecord (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status;
        String employeeId = request.getParameter("employeeId");
        try {
            int id = Integer.parseInt(request.getParameter("leaveId"));
            LeaveRecord leaveRecord = employeeController.getLeaveRecord(id, employeeId);
            leaveRecord.setFromDate(request.getParameter("fromDate"));
            leaveRecord.setToDate(request.getParameter("toDate"));
            leaveRecord.setLeaveType(request.getParameter("LeaveType"));
            boolean isUpdated = employeeController.updateLeaveRecord(leaveRecord);

            if (isUpdated) {
                status = "LeaveRecord updated successfully";
            } else {
                status = "LeaveRecord not updated";
            }
            request.setAttribute("status", status);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performUpdateLeaveRecord.jsp");
            requestDispatcher.include(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("leaveRecord", "Invalid Leave ID");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performEditLeaveRecord.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();

        switch (action) {
            case "/readLeaveRecordByEmployeeId":
                getLeaveRecordByEmployeeId(request, response);
                break;

            case "/readLeaveRecord":
                getAllLeaveRecords(request, response);
                break;

            case "/getEmployeeForLeave":
                getEmployee(request, response);
                break;

            case "/deleteLeaveRecord":
                deleteLeaveRecord(request, response);
                break;

            case "/getEmployeeForUpdate":
                getEmployeeForUpdate(request, response);
                break;

            case "/getLeaveId":
                getLeaveRecord(request, response);
                break;
        }
    }

    private void getEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoResultException {
        try {
            String employeeId = request.getParameter("employeeId");
            Employee employee = employeeController.getEmployeeById(employeeId);
            if (employee != null) {
                request.setAttribute("employee", employee);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performAddLeaveRecord.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (NoResultException e) {
            request.setAttribute("employee",e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetEmployeeForLeave.jsp");
            requestDispatcher.include(request, response);
        }
    }

    private void getEmployeeForUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoResultException {
        try {
            String employeeId = request.getParameter("employeeId");
            Employee employee = employeeController.getEmployeeById(employeeId);
            if (employee != null) {
                List<LeaveRecord> leaveRecords = employeeController.getLeaveRecordByEmployeeId(employee.getEmployeeId());
                if (null != leaveRecords) {
                    request.setAttribute("leaves", leaveRecords);
                } else {
                    request.setAttribute("leaves", "No Leave Records");
                }
                request.setAttribute("employee", employee);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetLeaveId.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (NoResultException e) {
            request.setAttribute("notFound",e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performEditLeaveRecord.jsp");
            requestDispatcher.include(request, response);
        }
    }
    private void getAllLeaveRecords(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<LeaveRecord> leaveRecords = employeeController.printLeaveRecords();
        if (leaveRecords.isEmpty()) {
            request.setAttribute("leaveRecords", "No Leave Records");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetLeaveRecord.jsp");
            requestDispatcher.include(request, response);
        } else {
            request.setAttribute("leaves", leaveRecords);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performReadLeaveRecords.jsp");
            requestDispatcher.include(request, response);
        }
    }

    private void getLeaveRecordByEmployeeId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoResultException {
        String employeeId = request.getParameter("employeeId");
        try {
            Employee employee = employeeController.getEmployeeById(employeeId);
            List<LeaveRecord> leaveRecords = employeeController.getLeaveRecordByEmployeeId(employee.getEmployeeId());

            if (null != leaveRecords) {
                request.setAttribute("leaves", leaveRecords);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performReadLeaveRecords.jsp");
                requestDispatcher.forward(request, response);
            } else {
                request.setAttribute("leave", "No Leave Records");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performLeaveRecordEmployeeById.jsp");
                requestDispatcher.include(request, response);
            }
        } catch (NoResultException e) {
            request.setAttribute("leave", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performLeaveRecordEmployeeById.jsp");
            requestDispatcher.include(request, response);
        }
    }

    private void deleteLeaveRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoResultException {
        String employeeId = request.getParameter("employeeId");
        String status;

        try {
            Employee employee = employeeController.getEmployeeById(employeeId);
            int updatedRow = employeeController.deleteLeaveRecord(employeeId);

            if (updatedRow > 0) {
                status = "Leave Record Deleted ";
            } else {
                status = "No Leave Record";
            }
            request.setAttribute("status",status);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performDeleteLeaveRecord.jsp");
            requestDispatcher.include(request, response);
        } catch (NoResultException e) {
            request.setAttribute("status", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performDeleteLeaveRecord.jsp");
            requestDispatcher.include(request, response);
        }
    }
}