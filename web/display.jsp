<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bean.Faculty" %><%--
  Created by IntelliJ IDEA.
  User: Soumay
  Date: 29-03-2020
  Time: 04:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Display Faculty</title>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Stream</th>
            <th>Salary</th>
            <th>Years Of experience</th>
            <th>Phone</th>
            <th>Grade</th>
        </tr>
        <%
            ArrayList<Faculty> facs=(ArrayList<Faculty>)request.getAttribute("result");
            for(Faculty f:facs){
        %>
            <tr>
                <td><%=f.getId()%></td>
                <td><%=f.getName()%></td>
                <td><%=f.getAddress()%></td>
                <td><%=f.getStream()%></td>
                <td><%=f.getSalary()%></td>
                <td><%=f.getYears_of_experience()%></td>
                <td><%=f.getPhoneno()%></td>
                <td><%=f.getGrade()%></td>
            </tr>
        <%
            }
        %>
    </table>
    <a href='index.jsp'>Back to home</a>
</body>
</html>
