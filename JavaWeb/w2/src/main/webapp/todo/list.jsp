<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 4. 17.
  Time: 오후 4:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Todo - List</title>
</head>
<body>
    <h1>Todo List</h1>
    <ul>
        <c:forEach items="${dtoList}" var="dto">
            <li><a href="read?tno=${dto.tno}">${dto.tno}</a> ${dto.title} ${dto.dueDate} ${dto.finished}</li>
        </c:forEach>
    </ul>
</body>
</html>
