<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/styles.css"/>
<title>Editar Localizacion</title>
</head>
<body>
	<nav>
		<ul><a href="/localizaciones/agregar">Agregar Localización</a></ul>
		<ul><a href="/logout">Cerrar Sesion</a></ul>
		<ul><a href="/localizaciones">Editar Localizacion</a></ul>
	</nav>
	<h2>Editar Localizacion</h2>
	
	<form:form action = "/editar/${localizacion.id}" method = "POST" modelAttribute = "localizacion">
		<input type = "hidden" name = "_method" value = "PUT"/>
		
		<div class = "columna">
		
			<form:label path = "nombre">Nombre:</form:label>
			<form:input type = "text" path = "nombre"/>
			<form:errors path = "nombre"/>
			
            <form:label path = "direccion">Direccion:</form:label>
			<form:input type = "text" path = "direccion"/>
			<form:errors path = "direccion"/>
			
			<input type = "submit" value = "Editar"/>
            
			<form action="/eliminar/${localizacion.id}" method="POST">
				<input type="hidden" name="_method" value="DELETE"/>
				<button>Eliminar</button>
			</form>
		</div>
	</form:form>
</body>
</html>