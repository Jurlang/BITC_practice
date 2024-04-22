<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Practice - Login</title>
</head>
<body>
	<h1>Login Page</h1>
	<c:if test="${param.result == 'error'}">
		<h1>로그인 에러(아이디 혹은 비밀번호가 맞지 않습니다!)</h1>
	</c:if>
	<form action="./login" method="post">
		<input type="text" name="mid" id="mid" placeholder="아이디 입력란">
		<input type="password" name="mpw" id="mpw" placeholder="비밀번호 입력란">
		<label for="auto"><input type="checkbox" name="auto" id="auto">로그인유지</label>
		<button type="submit">로그인</button>
	</form>
</body>
</html>
