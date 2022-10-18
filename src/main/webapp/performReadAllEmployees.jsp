<%@ page import="com.ideas2it.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Employee Details</title>
    </head>

    <body>
        <h2>Employee Details</h2>
        <%!private Gson gson = new Gson();%>
        <%List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
          for (Employee employee : employeeList) {
              employee.setEmployeeProjects(null);
              employee.setLeaveRecords(null);
              String employees = this.gson.toJson(employee);%><br><br>
              <%=employees%>
          <%}%><br><br>
        <a href = "performGetEmployee.jsp">Back</a><br><br>
    </body>
</html>
