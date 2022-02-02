<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Alta alumno</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container mt-5">
		<a href="lista-alumnos"><i class="fas fa-arrow-left fa-2x text-black"></i></a>
		<h3 class="mt-5">Registro de alumnos</h3>
		<c:if test="${not empty mensaje}">
			<div class="alert alert-warning" role="alert">${mensaje}</div>
		</c:if>
		<form:form action="procesar-alumno" method="POST"
			modelAttribute="alumno">
			<div class="mb- col-4">
				<label for="formGroupExampleInput" class="form-label">Nombre</label>
				<form:input type="text" class="form-control"
					id="formGroupExampleInput" path="nombre" />
			</div>
			<div class="mb-3 col-4">
				<label for="formGroupExampleInput2" class="form-label">Apellido</label>
				<form:input type="text" class="form-control"
					id="formGroupExampleInput2" path="apellido" />
			</div>
			<div class="mb-3 col-4">
				<label for="formGroupExampleInput2" class="form-label">DNI</label>
				<form:input type="number" class="form-control"
					id="formGroupExampleInput2" path="dni" />
			</div>
			<button type="submit" class="btn btn-primary mt-2">Enviar</button>
		</form:form>
	</div>
</body>
</html>