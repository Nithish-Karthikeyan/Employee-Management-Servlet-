<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Read Leave Records</title>
</head>

<body>
<h2>Leave Records</h2>
<form action ="readLeaveRecord" method="get">
    <a href ="${pageContext.request.contextPath}/readLeaveRecord">Get All Leave Records</a><br><br>
    <a href ="performLeaveRecordEmployeeById.jsp">Get Leave Records of an Employee</a><br><br>
    <h4>${leaveRecords}</h4>
    <a href ="leaveRecords.jsp">Back to Menu</a>
</form>
</body>
</html>