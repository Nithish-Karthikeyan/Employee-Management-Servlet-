<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Employee Details</title>
    </head>

    <body>
        <h1>Employee Details</h1>
        <h3>Enter the Employee Id</h3>
        <form action="readEmployeeById" method="get">
            <label for = "employeeId"></label>
            <input type = "text" id = "employeeId" name = "employeeId"><br><br>
            <input type = "submit" value = "Submit">
        </form>
        <a href = "performGetEmployee.jsp">Back</a><br><br>
        <p>${employee}</p>
    </body>
</html>
