<%@ page import="com.ideas2it.model.LeaveRecord" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Leave Record</title>
    </head>

    <body>
        <h2>Update Leave Record</h2><br>
        <h3>Fill the details</h3><br>

        <form action = "updateLeaveRecord" method = "post">
            <%LeaveRecord leaveRecord = (LeaveRecord) request.getAttribute("leaveRecord");
            if (leaveRecord != null) {%>
            <input type="hidden" name="employeeId" value="${employee}">

            <input type ="text" name ="leaveId" value = "<%=leaveRecord.getLeaveId()%>" readonly><br>
            <label for="fromDate">From Date</label><br>
            <input type="date" id="fromDate" name="fromDate" required = "required" value = "<%=leaveRecord.getFromDate()%>"><br><br>

            <label for="toDate">TO Date</label><br>
            <input type="date" id="toDate" name="toDate" required = "required" value = "<%=leaveRecord.getToDate()%>"><br><br>

            <label for="leaveType" required = "required">Leave Type</label><br>
            <select name="leaveType" id="leaveType" value = "<%=leaveRecord.getLeaveType()%>">
                <option value="Casual Leave">Casual Leave</option>
                <option value="Medical Leave">Medical Leave</option>
                <option value="Sick Leave">Sick Leave</option>
            </select><br><br>

            <input type = "submit" value = "Submit">
        </form>
        <%}%>
        <h3>${status}</h3><br><br>
        <a href = "leaveRecords.jsp">Back to Menu</a>
    </body>
</html>