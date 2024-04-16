<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To-Do : Read</title>
</head>
<body>
    <h1>할 일</h1>
    <div>번호 : ${dto.tno}</div>
    <div>제목 : ${dto.title}</div>
    <div>날짜 : ${dto.dueDate}</div>
    <div>완료 :
        <c:choose>
            <c:when test="${dto.finished}">
                완료
            </c:when>
            <c:otherwise>
                미완료
            </c:otherwise>
        </c:choose></div>
</body>
</html>
