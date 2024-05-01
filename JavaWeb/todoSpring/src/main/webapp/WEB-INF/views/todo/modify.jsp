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
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

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
									<a class="nav-link active" aria-current="page" href="#">Home</a>
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
						<form action="modify" method="post">
							<div class="input-group mb-3">
								<span class="input-group-text">Title</span>
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
								<input type="text" name="writer" class="form-control" value="${dto.writer}">
							</div>
							<div class="my-4">
								<div class="float-end">
									<button type="submit" class="btn btn-primary">Submit</button>
									<button type="reset" class="btn btn-secondary">Reset</button>
								</div>
							</div>
							<div class="form-check">
								<label class="form-check-label">
									Finished &nbsp
								</label>
								<input class="form-check-input" type="checkbox" name="finished" ${dto.finished?"checked":""}>
							</div>
						</form>
						<script>
                            const serverValidResult = {}
                            <c:forEach items="${errors}" var="error">
                            serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
                            </c:forEach>
                            console.log(serverValidResult);
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>