<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2024-04-15
  Time: 오전 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Num1 : ${param.num1}</h1>
    <h1>Num2 : ${param.num2}</h1>
    <h1>Plus : ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)}</h1>
    <form action="input.jsp">
        <input type="submit" value="Return">
    </form>
</body>
</html>
