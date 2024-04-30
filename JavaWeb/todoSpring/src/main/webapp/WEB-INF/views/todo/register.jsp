<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 4. 30.
  Time: 오전 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<form action="./register" method="post">
	<div>
		<label>
			Title :
			<input type="text" name="title">
		</label>
	</div>
	<div>
		<label>
			DueDate :
			<input type="date" name="dueDate" value="2024-04-30">
		</label>
	</div>
	<div>
		<label>
			Writer :
			<input type="text" name="writer">
		</label>
	</div>
	<div>
		<label>
			Finished :
			<input type="checkbox" name="finished">
		</label>
	</div>
	<div>
		<button type="submit">Register</button>
	</div>
</form>
</body>
</html>
