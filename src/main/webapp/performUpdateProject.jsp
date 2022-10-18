<%@ page import="com.ideas2it.model.EmployeeProject" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Project</title>
</head>

<body>
<h2>Update Project</h2><br>
<h3>Fill the details</h3><br>

<form action = "updateProject" method = "post">
    <%EmployeeProject project = (EmployeeProject) request.getAttribute("project");
      if (project != null) {%>
    <input type ="hidden" name ="projectId" value="<%=project.getProjectId()%>">
    <label for="projectManagerName">Project Manager Name:</label><br>
    <input type="text" id="projectManagerName" name="projectManagerName" value="<%=project.getProjectManagerName()%>" readonly = "readonly"><br><br>

    <label for="projectName">Project Name:</label><br>
    <input type="text" id="projectName" name="projectName" value="<%=project.getProjectName()%>" required = "required" pattern = "([a-zA-Z0-9]{1,20}[\s.]?([a-zA-Z0-9]{1,20}[\s.]?)+)"><br><br>

    <label for="clientName">Client Name:</label><br>
    <input type="text" id="clientName" name="clientName" value="<%=project.getClientName()%>" required = "required" pattern = "([a-zA-Z]{1,20}[\s.]?([a-zA-Z]{1,20}[\s.]?)+)"><br><br>

    <label for="startDate">Project Start Date:</label><br>
    <input type="date" id="startDate" name="startDate"  value = "<%=project.getStartDate()%>"  required = "required"><br><br>

    <input type = "submit" value = "Submit">
    <%}%>
</form>
<h3>${status}</h3><br><br>
<a href = "projects.jsp">Back to Menu</a>
</body>
</html>