<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
					<div class="card-header">
						Featured
					</div>
					<div class="card-body">
						<form action="modify?${pageRequestDTO.link}" method="post">
							<div class="input-group mb-3">
								<span class="input-group-text">TNO</span>
								<input type="text" name="tno" class="form-control" value="${dto.tno}" readonly>
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text">Title</span>
								<input type="text" name="title" class="form-control" value="${dto.title}">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text">DueDate</span>
								<input type="date" name="dueDate" class="form-control" value="${dto.dueDate}">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text">Writer</span>
								<input type="text" name="writer" class="form-control" value="${dto.writer}" readonly>
							</div>
							<div class="form-check">
								<label for="finished" class="form-check-label">
									<input id="finished" class="form-check-input" type="checkbox" name="finished" ${dto.finished?"checked":""}>
									Finished
								</label>
							</div>
							<div class="my-4">
								<div class="float-start">
									<button type="button" class="btn btn-danger">Remove</button>
								</div>
								<div class="float-end">
									<button type="submit" class="btn btn-primary">Modify</button>
									<button type="button" class="btn btn-secondary">Back</button>
								</div>
							</div>
						</form>
						<script>
							// Validation Check
                            const serverValidResult = {}
							<c:if test="${errors != null}">alert("다시 작성해주세요.")</c:if>
                            <c:forEach items="${errors}" var="error">
                            serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
                            </c:forEach>
                            console.log(serverValidResult);
							// Click Remove Btn
                            const formDelete = document.querySelector("form");
                            document.querySelector(".btn-danger").addEventListener("click",function(e){
                                e.preventDefault();
                                e.stopPropagation();
                                formDelete.action=`remove`;
                                formDelete.method="post";
                                formDelete.submit();
                            }, false);
                            // Click Back Btn
                            document.querySelector(".btn-secondary").addEventListener("click", function(e){
                                e.preventDefault();
                                e.stopPropagation();
                                self.location=`read?tno=${dto.tno}&${pageRequestDTO.link}`;
                            }, false);
						</script>
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
</html>