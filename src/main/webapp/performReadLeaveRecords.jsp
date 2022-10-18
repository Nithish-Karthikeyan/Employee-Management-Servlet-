<%@ page import="com.ideas2it.model.LeaveRecord" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Leave Records</title>
    </head>

    <body>
        <h2>Leave Records</h2>
        <%!private Gson gson = new Gson();%>
        <%List<LeaveRecord> leaveRecords = (List<LeaveRecord>) request.getAttribute("leaves");
          if(leaveRecords != null) {
              for (LeaveRecord leave: leaveRecords) {
              leave.setEmployee(null);
              String leaveRecord = this.gson.toJson(leave);%><br><br>
              <%=leaveRecord%>
            <%}%>
          <%}%><br><br>
        <a href = "performGetLeaveRecord.jsp">Back</a><br><br>
    </body>
</html>