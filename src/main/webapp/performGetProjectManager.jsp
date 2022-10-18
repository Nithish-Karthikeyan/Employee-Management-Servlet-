<%@ page import="com.ideas2it.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project</title>
</head>
<body>
<h3>Enter Project Manager Id</h3>
<form action="getProjectManager" method="post">
    <%Employee employee = (Employee) request.getAttribute("employee");%>
    <%if (employee != null) {%>
    <input type="hidden" name = "employeeId" value = "<%=employee.getEmployeeId()%>">
    <input type = "text"  name = "projectManagerId"><br><br>
    <input type = "submit" value = "Submit">
    <%}%>
</form>
<a href = "projects.jsp">Back</a><br><br>
</body>
</html>
