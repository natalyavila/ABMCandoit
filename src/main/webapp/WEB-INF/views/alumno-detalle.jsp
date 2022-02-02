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
<title>Alumno detalle</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container mt-5">
		<a href="${pageContext.request.contextPath}/alumnos/lista-alumnos"><i class="fas fa-arrow-left fa-2x text-black"></i></a>
		<h3 class="mt-5">Información del alumno</h3>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido</th>
					<th scope="col">DNI</th>
					<th scope="col">Curso</th>
					<th scope="col">Código de curso</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">${alumno.id}</th>
					<td>${alumno.nombre}</td>
					<td>${alumno.apellido}</td>
					<td>${alumno.dni}</td>
					<td><c:if test="${empty alumnos.curso.id}">
							Sin curso
						</c:if> <c:if test="${not empty alumnos.curso.id}">
							${alumnos.curso.nombre}
						</c:if></td>
					<td>${alumno.curso.id}</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>