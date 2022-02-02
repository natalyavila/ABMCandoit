<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<body>
	<%@ include file="header.jsp"%>
	<div class="container mt-5">
			<a href="${pageContext.request.contextPath}/cursos/curso-detalle/${curso.id}"><i
			class="fas fa-arrow-left fa-2x text-black"></i></a>
		<h2 class="mt-5">Alumnos sin curso</h2>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Alumno</th>
					<th scope="col">DNI</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="alumno" items="${listaAlumnosSinCurso}"
					varStatus="status">
					<tr>
						<th scope="row">${alumno.id}</th>
						<td>${alumno.nombre} ${alumno.apellido}</td>
						<td>${alumno.dni}</td>
						<td><a
							href="${pageContext.request.contextPath}/cursos/agregar-alumno/${curso.id}/${alumno.id}"><i
								class="fas fa-plus"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>
