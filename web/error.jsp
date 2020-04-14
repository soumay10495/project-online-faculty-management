<%--
  Created by IntelliJ IDEA.
  User: Soumay
  Date: 31-03-2020
  Time: 04:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    Error occurred...
    <br><br>
    <%
        out.println(exception.toString());
    %>
</body>
</html>
