<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 4. 17.
  Time: 오후 4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo - Detail</title>
</head>
<body>
    <h1>Todo Detail</h1>

    <div>제목 : ${dto.title}</div>
    <div>날짜 : ${dto.dueDate}</div>
    <div>완료 : ${dto.finished}</div>

<a href="list">목록</a>
</body>
</html>
