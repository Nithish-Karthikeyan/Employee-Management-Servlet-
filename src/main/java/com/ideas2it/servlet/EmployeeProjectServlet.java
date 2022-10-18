package com.ideas2it.servlet;

import com.ideas2it.controller.EmployeeController;
import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeProject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.NoResultException;
import java.io.IOException;
import java.util.List;

public class EmployeeProjectServlet extends HttpServlet {
    private final EmployeeController employeeController = new EmployeeController();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();

        switch (action) {
            case "/addProject":
                addProject(request, response);
                break;

            case "/updateProject":
                updateProject(request, response);
                break;

            case "/getProjects":
                getProjects(request, response);
                break;

            case "/getProjectsByEmployeeId":
                getProjectsByEmployeeId(request, response);
                break;

            case "/getEmployeeForProject":
                getEmployeeForProject(request, response);
                break;

            case "/getProjectManager":
                getProjectManager(request, response);
                break;

            case "/getEmployeeForProjectUpdate":
                getEmployeeForProjectUpdate(request, response);
                break;

            case "/getProjectId":
                getProjectId(request,response);
                break;
        }
    }

    private void getEmployeeForProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Employee employee = employeeController.getEmployeeById(request.getParameter("employeeId"));
            if (employee != null) {
                request.setAttribute("employee", employee);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetProjectManager.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (NoResultException e) {
            request.setAttribute("employee",e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetEmployeeForProject.jsp");
            requestDispatcher.include(request, response);
        }
    }

    private void getProjectManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Employee employee = employeeController.getEmployeeById(request.getParameter("employeeId"));
            Employee projectManager = employeeController.getEmployeeById(request.getParameter("projectManagerId"));
            if (projectManager != null) {
                request.setAttribute("employee", employee);
                request.setAttribute("projectManager", projectManager);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performAddProject.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (NoResultException e) {
            request.setAttribute("projectManager",e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetEmployeeForProject.jsp");
            requestDispatcher.include(request, response);
        }
    }

    private void getProjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EmployeeProject> projects = employeeController.printEmployeeProjects();
        if (projects.isEmpty()) {
            request.setAttribute("projects", "No projects");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetProjects.jsp");
            requestDispatcher.include(request, response);
        } else {
            request.setAttribute("projects", projects);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetProjects.jsp");
            requestDispatcher.include(request, response);
        }
    }

    private void getProjectsByEmployeeId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("employeeId");
        try {
            Employee employee = employeeController.getEmployeeById(employeeId);
            List<EmployeeProject> projects = employeeController.getEmployeeProjectByEmployeeId(employee.getEmployeeId());

            if (null != projects) {
                request.setAttribute("projects", projects);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetProjects.jsp");
                requestDispatcher.forward(request, response);
            } else {
                request.setAttribute("projects", "No projects found");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetProjectEmployeeById.jsp");
                requestDispatcher.include(request, response);
            }
        } catch (NoResultException e) {
            request.setAttribute("projects", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetProjectEmployeeById.jsp");
            requestDispatcher.include(request, response);
        }
    }

    private void addProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = employeeController.getEmployeeById(request.getParameter("employeeId"));
        String status;
        String projectName = request.getParameter("projectName");
        String projectManagerName = request.getParameter("projectManagerName");
        String clientName = request.getParameter("clientName");
        String startDate = request.getParameter("startDate");
        EmployeeProject project = new EmployeeProject(projectName, projectManagerName, clientName, startDate);
        int projectId = employeeController.addEmployeeProject(project,employee);

        if (projectId > 0)
            status = "Project created";
        else
            status = "Project not created";
        request.setAttribute("status",status);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("performAddProject.jsp");
        requestDispatcher.include(request, response);
    }

    private void getEmployeeForProjectUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("employeeId");
        try {
            Employee employee = employeeController.getEmployeeById(employeeId);
            List<EmployeeProject> projects = employeeController.getEmployeeProjectByEmployeeId(employee.getEmployeeId());

            if (null != projects) {
                request.setAttribute("employee",employee);
                request.setAttribute("projects", projects);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetProjectId.jsp");
                requestDispatcher.forward(request, response);
            } else {
                request.setAttribute("projects", "No projects found");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetEmployeeProject.jsp");
                requestDispatcher.include(request, response);
            }
        } catch (NoResultException e) {
            request.setAttribute("projects", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetEmployeeProject.jsp");
            requestDispatcher.include(request, response);
        }
    }

    private void getProjectId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("projectId");
        try {
            int projectId = Integer.parseInt(id);
            EmployeeProject project = employeeController.getProjectById(projectId);
            if (null != project) {
                request.setAttribute("project", project);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performUpdateProject.jsp");
                requestDispatcher.forward(request, response);
            } else {
                request.setAttribute("project", "No projects found");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetProjectId.jsp");
                requestDispatcher.include(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("ID", "Invalid Id");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performGetProjectId.jsp");
            requestDispatcher.forward(request, response);
        }
    }
    private void updateProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status;
        String projectId = request.getParameter("projectId");
        try {
            EmployeeProject project = employeeController.getProjectById(Integer.parseInt(projectId));
            project.setProjectName(request.getParameter("projectName"));
            project.setProjectManagerName(request.getParameter("projectManagerName"));
            project.setClientName(request.getParameter("clientName"));
            project.setStartDate(request.getParameter("startDate"));
            boolean isUpdated = employeeController.updateEmployeeProject(project);
            if (isUpdated) {
                status = "Project updated successfully";
            } else {
                status = "Project not updated";
            }
            request.setAttribute("status", status);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performUpdateProject.jsp");
            requestDispatcher.include(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("leaveRecord", "Invalid Project ID");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("performUpdateProject.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
