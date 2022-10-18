<%@ page import="com.ideas2it.model.Employee" %>
<%@ page import="com.ideas2it.model.EmployeeProject" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Project</title>
    </head>

    <body>
    <%Employee employee = (Employee) request.getAttribute("employee");
    if (employee != null) {%>
    <!--  <form action ="getProjectManagerForUpdate" method ="post">
    <p> Do you want to change Project Manager?</p><br><br>
    <input type = "radio" value = "change" id="changeProjectManager">
    <label for ="changeProjectManager">Yes</label>
    <input type = "radio" value = "NoChange" id = "NoChangeProjectManager">
    <label for="NoChangeProjectManager">No</label>
    <input type="submit" value="Submit">
    </form> -->
    <h2>Projects</h2><br>
    <%!private Gson gson = new Gson();%>
    <%List<EmployeeProject> projects = (List<EmployeeProject>) request.getAttribute("projects");
    if(projects != null) {
        for (EmployeeProject project: projects) {
        project.setEmployees(null);
        String employeeProject = this.gson.toJson(project);%><br><br>
        <%=employeeProject%>
        <%}%>
    <%}%><br><br>

    <form action = "getProjectId" method ="post">
         <input type ="hidden" name ="employeeId" value="<%=employee.getEmployeeId()%>">
         <label for ="projectId" required="required">Enter the Project ID:</label>
         <input type = "number" id ="projectId" name ="projectId">
         <input type ="submit" value = "Submit">
         <p>${project}</p>
         <p>${ID}</p>
    </form>
    <%}%>
    </body>
</html>
