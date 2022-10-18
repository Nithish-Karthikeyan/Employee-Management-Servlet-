<%@ page import="com.ideas2it.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Project</title>
</head>

<body>
<h2>Project</h2><br>
<h3>Fill the details</h3><br>

<form action = "addProject" method = "post">
    <%Employee employee = (Employee) request.getAttribute("employee");%>
    <%if (employee != null) {%>
    <%Employee projectManager = (Employee) request.getAttribute("projectManager");%>
    <%if (projectManager != null) {%>
    <label for = "employeeId">Employee ID :</label>
    <input type= "text" id="employeeId" name="employeeId" value ="<%=employee.getEmployeeId()%>" readonly="readonly" ><br><br>

    <label for="projectManagerName">Project Manager Name:</label><br>
    <input type="text" id="projectManagerName" name="projectManagerName" value="<%=projectManager.getEmployeeName()%>" readonly = "readonly"><br><br>

    <label for="projectName">Project Name:</label><br>
    <input type="text" id="projectName" name="projectName" required = "required" pattern = "([a-zA-Z0-9]{1,10}[\s.]?([a-zA-Z0-9]{1,20}[\s.]?)+)"><br><br>

    <label for="clientName">Client Name:</label><br>
    <input type="text" id="clientName" name="clientName" required = "required" pattern = "([a-zA-Z0-9]{1,10}[\s.]?([a-zA-Z0-9]{1,20}[\s.]?)+)"><br><br>

    <label for="startDate">Project Start Date:</label><br>
    <input type="date" id="startDate" name="startDate" required = "required"><br><br>

    <input type = "submit" value = "Submit">
    <%}%>
    <%}%>
</form>
<h3>${status}</h3><br><br>
<a href = "projects.jsp">Back to Menu</a>
</body>
</html>