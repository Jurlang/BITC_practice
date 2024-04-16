<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To-Do : List</title>
</head>
<body>
    <h1>할 일 리스트</h1>

    <ul>
        <c:forEach items="${list}" var="dto">
            <li><a href="read?tno=${dto.tno}">${dto.tno}</a> --- ${dto.title} --- ${dto.dueDate}</li>
        </c:forEach>
    </ul>

</body>
</html>
