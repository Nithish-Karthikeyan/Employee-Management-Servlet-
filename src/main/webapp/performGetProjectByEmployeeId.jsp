<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Projects</title>
    </head>

    <body>
        <h1>Projects</h1>
        <h3>Enter the Employee Id</h3>
        <form action="getProjectsByEmployeeId" method="post">
            <label for = "employeeId"></label>
            <input type = "text" id = "employeeId" name = "employeeId"><br><br>
            <input type = "submit" value = "Submit">
            <p>${projects}</p><br><br>
        </form>
        <a href = "performGetProject.jsp">Back</a><br><br>
    </body>
</html>