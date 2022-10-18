<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Leave Records</title>
    </head>

    <body>
        <h1>Leave Records</h1>
        <h3>Enter the Employee Id</h3>
        <form action="readLeaveRecordByEmployeeId" method="get">
            <label for = "employeeId"></label>
            <input type = "text" id = "employeeId" name = "employeeId"><br><br>
            <input type = "submit" value = "Submit">
            <a href = "performGetLeaveRecord.jsp">Back</a><br><br>
            <p>${leave}</p><br><br>
        </form>
    </body>
</html>