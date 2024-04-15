<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2024-04-15
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="makeResult" method="get">
    <label for="num1"></label><input type="number" name="num1" id="num1">
    <label for="num2"></label><input type="number" name="num2" id="num2">
    <input type="submit" value="GET_SEND">
</form>
<form action="/w1/calc/makeResult" method="post">
    <label for="num3"></label><input type="number" name="num1" id="num3">
    <label for="num4"></label><input type="number" name="num2" id="num4">
    <input type="submit" value="POST_SEND">
</form>

</body>
</html>
