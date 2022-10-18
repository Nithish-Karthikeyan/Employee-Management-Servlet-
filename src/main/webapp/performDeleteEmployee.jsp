<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <title>Delete</title>
    </head>
    <body>
        <h2>Delete the Employee</h2><br><br>
        <h3>Enter the Employee Id</h3>
        <form action="deleteEmployee" method="get">
            <label for = "employeeId"></label>
            <input type = "text" id = "employeeId" name = "employeeId"><br><br>
            <input type = "submit" value = "Submit">
        </form>
        <a href = "employee.jsp">Back to Menu</a>
        <h3>${status}</h3><br><br>
    </body>
</html>
