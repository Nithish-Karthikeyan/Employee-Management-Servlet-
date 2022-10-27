<%@ page import="com.ideas2it.model.EmployeeProject" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Projects</title>
    </head>

    <body>
        <h2>Projects</h2>
        <%!private Gson gson = new Gson();%>
        <%List<EmployeeProject> projects = (List<EmployeeProject>) request.getAttribute("projects");
          for (EmployeeProject project: projects) {
              project.setEmployees(null);
              String employeeProject = this.gson.toJson(project);%><br><br>
              <%=employeeProject%>
        <%}%><br><br>
        <a href = "performGetProject.jsp">Back</a><br><br>
    </body>
</html>

