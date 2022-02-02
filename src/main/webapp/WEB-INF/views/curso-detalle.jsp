<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Curso detalle</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container mt-5">
		<a href="${pageContext.request.contextPath}/cursos/lista-cursos"><i
			class="fas fa-arrow-left fa-2x text-black"></i></a>
		<h3 class="mt-5">Informacion del curso</h3>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Curso</th>
					<th scope="col">Profesor</th>
					<th scope="col">Turno</th>
					<th scope="col">Cantidad de alumnos</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">${curso.id}</th>
					<td>${curso.nombre}</td>
					<td>${curso.profesor}</td>
					<td>${curso.turno}</td>
					<td>${cantidad}</td>
					<td><a
						href="${pageContext.request.contextPath}/cursos/agregar-alumno/${curso.id}"><button class="btn btn-primary">Agregar
							alumno</button></a></td>
				</tr>
			</tbody>
		</table>
		<h3 class="mt-5">Alumnos inscriptos</h3>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nombre</th>
					<th scope="col">DNI</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="alumno" items="${alumnos}" varStatus="status">
					<tr>
						<th scope="row">${alumno.id}</th>
						<td>${alumno.nombre} ${alumno.apellido}</td>
						<td>${alumno.dni}</td>
						<td><a
							href="${pageContext.request.contextPath}/cursos/eliminar-alumno-curso/${curso.id}/${alumno.id}"><i
								class="fas fa-trash text-danger"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>