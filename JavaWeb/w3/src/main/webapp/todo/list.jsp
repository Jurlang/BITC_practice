<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Todo - List</title>
</head>
<body>

    <h1>Todo List</h1>
    <form action="../logout" method="post">
        <c:if test="${loginInfo != null}">
            ${loginInfo.mname}님 어서오세요.
        </c:if>
        <button type="submit">로그아웃</button>
    </form>
    <ul>
        <c:forEach items="${dtoList}" var="dto">
            <li><a href="read?tno=${dto.tno}">${dto.tno}</a> ${dto.title} ${dto.dueDate} ${dto.finished ? "완료" : "미완료"}</li>
        </c:forEach>
    </ul>

    <input type="button" value="등록" onclick="location.href='insert'"/>

</body>
</html>
