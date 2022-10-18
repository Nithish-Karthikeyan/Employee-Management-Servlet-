<%@ page import="com.ideas2it.model.Employee" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.ideas2it.model.LeaveRecord" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Leave Record</title>
    </head>

    <body>
        <%Employee employee = (Employee) request.getAttribute("employee");
        if(employee != null) {%>
        <p>Employee ID:</p>
        <input type = "text" name ="employeeId" value = "<%=employee.getEmployeeId()%>" readonly><br><br>
        <%!private Gson gson = new Gson();%>
        <%List<LeaveRecord> leaveRecords = (List<LeaveRecord>) request.getAttribute("leaves");
        if(leaveRecords != null) {
            for (LeaveRecord leave: leaveRecords) {
                leave.setEmployee(null);
                String leaveRecord = this.gson.toJson(leave);%>
                <%=leaveRecord%><br><br>
          <%}%>
        <%}%>
        <form action ="getLeaveId" method="get">
            <input type = "hidden" name ="employeeId" value = "<%=employee.getEmployeeId()%>"><br><br>
            <label for ="leaveId" required="required">Enter the leave ID for the record which you want to edit</label><br><br>
            <input type="number" id="leaveId" name="leaveId">
            <input type="submit" value="Submit">
            <p>${leaveRecord}</p>
        </form>
       <%}%>
    </body>
</html>
