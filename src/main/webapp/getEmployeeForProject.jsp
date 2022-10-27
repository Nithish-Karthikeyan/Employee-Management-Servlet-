<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project</title>
</head>

<body>
<h1>Employee Details</h1>
<h3>Enter the Employee Id</h3>
<form action="getEmployeeForProjects" method="get">
    <label for = "employeeId"></label>
    <input type = "text" id = "employeeId" name = "employeeId"><br><br>
    <input type = "submit" value = "Submit">
</form>
<a href = "index.jsp">Back</a><br><br>
<p>${employee}</p>
<p>${projects}</p>
</body>
</html>