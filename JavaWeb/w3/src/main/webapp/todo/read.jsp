<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Todo - Read</title>
</head>
<body>
    <h1>Todo Read</h1>

    <div>제목 : ${dto.title}</div>
    <div>날짜 : ${dto.dueDate}</div>
    <div>완료 : ${dto.finished ? "완료" : "미완료"}</div>

    <input type="button" value="목록" onclick="location.href='list'"/>
    <input type="button" value="수정" onclick="location.href='update?tno=${dto.tno}'"/>
    <input type="button" value="삭제" onclick="location.href='delete?tno=${dto.tno}'"/>
</body>
</html>
