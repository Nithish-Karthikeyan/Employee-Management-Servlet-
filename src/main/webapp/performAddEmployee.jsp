<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Add an employee</title>
    </head>

    <body>
        <h2>Add Employee</h2><br>
        <h3>Fill the details</h3><br>

        <form action = "addEmployee" method = "post">
            <label for = "name">Name</label><br>
            <input type = "text" id = "name" name = "employeeName" required = "required" minlength="3" maxlength="40" pattern ="([a-zA-Z]{1,10}[\s.]?([a-zA-Z]{1,20}[\s.]?)+)"><br><br>

            <label for="gender" required = "required">Gender</label><br>
            <select name="gender" id="gender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select><br><br>

            <label for="employeeType" required = "required">Employee Type</label><br>
            <select name="employeeType" id="employeeType">
                <option value="Trainer">Trainer</option>
                <option value="Trainee">Trainee</option>
            </select><br><br>

            <label for="dateOfBirth">Date Of Birth</label><br>
            <input type="date" id="dateOfBirth" name="dateOfBirth" required = "required"><br><br>

            <label for = "mobileNumber">Mobile Number</label><br>
            <input type = "text" id = "mobileNumber" name = "mobileNumber" required = "required" minlength="10" maxlength="10" pattern = "^[6789]{1}[0-9]{9}"><br><br>

            <label for = "emailId">Email Id</label><br>
            <input type = "email" id = "emailId" name = "emailId" required = "required" pattern = "(^([a-z0-9_.-]{3,})+@([a-z0-9_.-]+)+[a-z.]{2,}$)"><br><br>

            <label for = "designation">Designation</label><br>
            <input type = "text" id = "designation" name = "designation" required = "required" pattern = "([a-zA-Z]{1,10}[\s.]?([a-zA-Z]{1,20}[\s.]?)+)"><br><br>

            <input type = "submit" value = "Submit">
        </form>

        <h3>${status}</h3><br><br>
        <a href = "employee.jsp">Back to Menu</a>
    </body>
</html>
