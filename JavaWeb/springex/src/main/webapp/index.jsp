<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<ul>
	<li><a href="hello-servlet">Hello Servlet</a></li>
	<li><a href="hello">Sample Hello</a></li>
	<li><a href="todo/list">Todo List</a></li>
	<li><a href="todo/register">Todo Register</a></li>
	<li><a href="ex1">ex1</a></li>
	<li><a href="ex2">ex2</a></li>
	<li><a href="ex2?name=ccc&age=123">ex2 name ccc age 123</a></li>
	<li><a href="ex3?dueDate=2024-04-30">ex3 dueDate=2024-04-30</a></li>
	<li><a href="ex4">ex4 Model</a></li>
	<li><a href="ex4_1?tno=3&title=123&dueDate=2024-04-30&finished=true&writter=hyeon">ex4_1 todoDTO, model</a></li>
	<li><a href="ex4_2?tno=3&title=123&dueDate=2024-04-30&finished=true&writter=hyeon">ex4_2 todoDTO</a></li>
	<li><a href="ex5">ex5</a></li>
	<li><a href="ex7?p1=aaa&p2=123">ex7 p1 aaa p2 123</a></li>
	<li><a href="ex7?p1=aaa&p2=aaa">ex7 p1 aaa p2 aaa</a></li>
	<li><a href="ex8">ex8 404 exception test</a></li>
</ul>
</body>
</html>