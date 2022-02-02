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
		<h2>Cursos listados</h2>
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
		<a href="registrar-curso"><button class="btn btn-primary me-md-2">Alta curso</button></a>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nombre</th>
					<th scope="col">Profesor</th>
					<th scope="col">Turno</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cursos" items="${listaCursos}" varStatus="status">
					<tr>
						<th scope="row">${cursos.id}</th>
						<td>${cursos.nombre}</td>
						<td>${cursos.profesor}</td>
						<td>${cursos.turno}</td>
						<td><a
							href="${pageContext.request.contextPath}/cursos/curso-detalle/${cursos.id}"><i
								class="fas fa-eye text-secondary"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>