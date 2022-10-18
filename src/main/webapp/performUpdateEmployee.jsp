<%@ page import="com.ideas2it.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Update</title>
    </head>

    <body>
        <h2>Update the Employee Details</h2><br><br>
        <form action="getEmployee" method="get">

        <label for = "employeeId"></label>
        <input type = "text" id = "employeeId" name = "employeeId"><br><br>

        <input type = "submit" value = "Submit">
        </form>
        <h5>${employee}</h5>
        <a href = "employee.jsp">Back to Menu</a>
    </body>
</html>
