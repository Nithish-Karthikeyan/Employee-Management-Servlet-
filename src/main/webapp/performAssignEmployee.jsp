<%@ page import="com.ideas2it.model.Employee" %>
<%@ page import="com.ideas2it.model.EmployeeProject" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Project</title>
    </head>

    <body>
        <h2>Assign Employee For Project</h2>
        <%!private Gson gson = new Gson();%>
        <%Employee employee = (Employee) request.getAttribute("employee");
        List<EmployeeProject> projects = (List<EmployeeProject>) request.getAttribute("projects");
        if (null != employee && null != projects) {
            for (EmployeeProject project: projects) {
            project.setEmployees(null);
            String employeeProject = this.gson.toJson(project);%><br><br>
            <%=employeeProject%>
            <%}%><br><br>
        <form action ="assignEmployee" method = "post">
            <input type ="hidden" name ="employeeId" value="<%=employee.getEmployeeId()%>">
            <label for ="projectId" required="required">Enter the Project ID:</label>
            <input type = "number" id ="projectId" name ="projectId">
            <input type ="submit" value = "Submit">
            <p>${project}</p>
            <p>${status}</p>
        <%}%><br><br>
        </form>
     <a href = "getEmployeeForProject.jsp">Back</a>
    </body>
</html>
