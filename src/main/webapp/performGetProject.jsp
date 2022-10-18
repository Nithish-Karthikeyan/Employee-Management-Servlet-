<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Projects</title>
</head>

<body>
<h2>Employee Projects</h2>
<form action ="getProjects" method="post">
    <a href ="${pageContext.request.contextPath}/getProjects">Get All Projects</a><br><br>
    <a href ="performGetProjectByEmployeeId.jsp">Get Project Details of an Employee</a><br><br>
    <h4>${projects}</h4>
    <a href ="projects.jsp">Back to Menu</a>
</form>
</body>
</html>