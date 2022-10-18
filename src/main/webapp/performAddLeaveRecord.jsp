<%@ page import="com.ideas2it.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Leave Record</title>
</head>

<body>
<h2>Add Leave Record</h2><br>
<h3>Fill the details</h3><br>

<form action = "addLeaveRecord" method = "post">
    <%Employee employee = (Employee) request.getAttribute("employee");%>
    <%if (employee != null) {%>
    <label for = "employeeId">Employee ID :</label>
    <input type= "text" id="employeeId" name="employeeId" value ="<%=employee.getEmployeeId()%>" readonly="readonly" ><br><br>

    <label for="fromDate">From Date:</label><br>
    <input type="date" id="fromDate" name="fromDate" required = "required"><br><br>

    <label for="toDate">To Date:</label><br>
    <input type="date" id="toDate" name="toDate" required = "required"><br><br>

    <label for="leaveType" required = "required">Leave Type</label><br>
    <select name="leaveType" id="leaveType">
        <option value="Casual Leave">Casual Leave</option>
        <option value="Medical Leave">Medical Leave</option>
        <option value="Sick Leave">Sick Leave</option>
    </select><br><br>

    <input type = "submit" value = "Submit">
    <%}%>
</form>
<h3>${status}</h3><br><br>
<a href = "leaveRecords.jsp">Back to Menu</a>
</body>
</html>