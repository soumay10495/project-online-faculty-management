<%--
  Created by IntelliJ IDEA.
  User: Soumay
  Date: 29-03-2020
  Time: 04:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Add Faculty</title>
</head>
<body>
    <form action="add" method="post">
        Name <input type="text" name="name" pattern="[a-zA-Z ]*" maxlength="15" required>
        Address <textarea name="address" rows="5" cols="20" maxlength="40"></textarea>
        Stream <select name="stream">
                <option value="science">Science</option>
                <option value="commerce">Commerce</option>
                <option value="arts">Arts</option>
               </select>
        Salary <input type="text" name="salary" pattern="[0-9]*"required>
        Years of experience <input type="text" id="years" name="years" min="1" max="5" required>
        Phone <input type="text" name="phone" pattern="[0-9]*" maxlength="10" minlength="10" required>
        Grade <select name="grade">
                <option value="A" selected>A</option>
                <option value="B">B</option>
                <option value="C">C</option>
              </select>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset form">
    </form>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
