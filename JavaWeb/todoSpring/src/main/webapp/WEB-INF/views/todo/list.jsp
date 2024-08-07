<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 5. 1.
  Time: 오전 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<title>Hello,world!</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="row">
			<div class="col">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<div class="container-fluid">
						<a class="navbar-brand" href="#">Navbar</a>
						<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarNav">
							<ul class="navbar-nav">
								<li class="nav-item">
									<a class="nav-link active" aria-current="page" href="/todoSpring">Home</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#">Features</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#">Pricing</a>
								</li>
								<li class="nav-item">
									<a class="nav-link disabled">Disabled</a>
								</li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
		<div class="row content">
			<div class="col">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Search</h5>
						<form action="list" method="get">
							<input type="hidden" name="size" value="${pageRequestDTO.size}">
							<div class="mb-3">
								<label for="chkFinish"><input type="checkbox" name="finished" id="chkFinish" ${pageRequestDTO.finished?"checked":""}>완료여부</label>
							</div>
							<div class="mb-3">
								<label for="inputTypeT"><input type="checkbox" name="types" id="inputTypeT" value="t" ${pageRequestDTO.checkType("t")?"checked":""}>제목</label>
								<label for="inputTypeW"><input type="checkbox" name="types" id="inputTypeW" value="w" ${pageRequestDTO.checkType("w")?"checked":""}>작성자</label>
								<input type="text" name="keyword" class="form-control" value='<c:out value="${pageRequestDTO.keyword}"/>'>
							</div>
							<div class="input-group mb-3 dueDateDiv">
								<input type="date" name="from" class="form-control" value="${pageRequestDTO.from}">
								<input type="date" name="to" class="form-control" value="${pageRequestDTO.to}">
							</div>
							<div class="input-group mb-3">
								<div class="float-end">
									<button class="btn btn-primary" type="submit">Search</button>
									<button class="btn btn-info clearBtn" type="reset">Clear</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="row content">
			<div class="col">
				<div class="card">
					<div class="card-header">
						Featured
					</div>
					<div class="card-body">
						<h5 class="card-title">Special title treatment</h5>
						<table class="table">
							<thead>
							<tr>
								<th scope="col">TNO</th>
								<th scope="col">Title</th>
								<th scope="col">Writer</th>
								<th scope="col">DueDate</th>
								<th scope="col">Finished</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${responseDTO.dtoList}" var="dto">
								<tr>
									<th scope="row"><c:out value="${dto.tno}"/></th>
									<td><a href="read?tno=${dto.tno}&${pageRequestDTO.link}" class="text-decoration-none"><c:out value="${dto.title}"/></a></td>
									<td><c:out value="${dto.writer}"/></td>
									<td><c:out value="${dto.dueDate}"/></td>
									<td><c:out value="${dto.finished}"/></td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<div class="float-start">
							<button class="btn btn-primary" onclick="self.location='register'">Register</button>
						</div>
						<div class="float-end">
							<ul class="pagination flex-wrap">
								<c:if test="${responseDTO.prev}">
									<li class="page-item">
										<a class="page-link" data-num="${responseDTO.start-1}">Prev</a>
									</li>
								</c:if>
								<c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
									<li class="page-item ${responseDTO.page==num?"active":""}"><a class="page-link" data-num="${num}">${num}</a></li>
								</c:forEach>
								<c:if test="${responseDTO.next}">
									<li class="page-item">
										<a class="page-link" data-num="${responseDTO.end+1}">Next</a>
									</li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row content">
		<h1>Content</h1>
	</div>
	<div class="row footer">
		<div class="row fixed-bottom" style="z-index:-100">
			<footer class="py-1 my-1">
				<p class="text-center text-muted">Footer</p>
			</footer>
		</div>
	</div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js" integrity="sha512-pax4MlgXjHEPfCwcJLQhigY7+N8rt6bVvWLFyUMuxShv170X53TRzGPmPkZmGBhk+jikR8WBM4yl7A9WMHHqvg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script></body>
<script>
	// Pagination
	document.querySelector(".pagination").addEventListener("click",function(e){
        e.preventDefault();
        e.stopPropagation();

        const target = e.target;

        if(target.tagName !== 'A'){
            return;
        }

        const num = target.getAttribute("data-num");

        const formObj = document.querySelector("form");

        formObj.innerHTML += `<input type='hidden' name='page' value='\${num}'>`

        formObj.submit();
	}, false);

    document.querySelector(".clearBtn").addEventListener("click", function(e){
        e.preventDefault();
        e.stopPropagation();

        self.location="list";
    }, false);
</script>
</html>