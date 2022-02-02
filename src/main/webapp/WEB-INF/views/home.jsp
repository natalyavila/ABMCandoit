<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link href="./css/home.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row mt-5" style="margin: 200px">
			<div class="col">
				<div class="card" style="width: 18rem;">
					<a href="alumnos/lista-alumnos"> <img
						src="https://www.wallpapertip.com/wmimgs/49-493380_students-images-hd-png.jpg"
						class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">
								<strong>Administrar alumnos</strong>
							</p>
						</div>
					</a>
				</div>
			</div>
			<div class="col">
				<div class="card" style="width: 18rem;">
					<a href="cursos/lista-cursos"> <img
						src="https://cdn.computerhoy.com/sites/navi.axelspringer.es/public/media/image/2018/07/leer-libros-todos-dias.jpg"
						class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">
								<strong>Administrar cursos</strong>
							</p>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>