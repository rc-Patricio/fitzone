<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
	<h2>Registro</h2>
<<<<<<< HEAD
	<form:form action = "/register" method = "POST" modelAttribute = "usuario">
		<div>
			<form:label path = "nombre">Nombre:</form:label>
			<form:input type = "text" path = "nombre"/>
			<form:errors path = "nombre"/>
			
			<form:label path = "apellido">Apellido:</form:label>
			<form:input type = "text" path = "apellido"/>
			<form:errors path = "apellido"/>
			
			<form:label path = "email">Correo:</form:label>
			<form:input type = "text" path = "email"/>
			<form:errors cssClass = "email" path = "email"/>

			
			<form:label path = "clave">Contraseña:</form:label>
			<form:input type = "password" path = "clave"/>
			<form:errors path = "clave"/>

            <form:label path="genero">Genero:</form:label> 
            <form:select path="genero" multiple="false">
                <option value="Hombre">Hombre</option>
                <option value="Mujer">Mujer</option>
                <option value="Otro">Otro</option>
            </form:select> 
            <form:errors class="error" path="genero"/>
			
			<form:label path = "confirmarClave">Confirmar Contraseña:</form:label>
			<form:input type = "password" path = "confirmarClave"/>
			<form:errors path = "confirmarClave"/>
			
			<input type = "submit" value = "Registrarse"/>
		</div>
=======
	<form:form action="/register" method="POST" modelAttribute="usuario">
		<nav>
			<ul>
				<li><a href="/login">Iniciar Sesión</a></ul>
			</ul>
		</nav>
		
		<form:label path="nombre">Nombre:</form:label>
		<form:input path="nombre" type="text" />
		<form:errors path="nombre" />
		
		<form:label path="apellido">Apellido:</form:label>
		<form:input path="apellido" type="text" />
		<form:errors path="apellido" />
		
		<form:label path="email">Email:</form:label>
		<form:input path="email" type="text" />
		<form:errors path="email" />

		<form:label path="genero">Genero:</form:label> 
		<form:select path="genero" multiple="false">
			<option value="Hombre">Hombre</option>
			<option value="Mujer">Mujer</option>
			<option value="Otro">Prefiero no decirlo</option>
		</form:select> 
		<form:errors path="genero"/>
		
		<form:label path="clave">Contraseña:</form:label>
		<form:input path="clave" type="password" />
		<form:errors path="clave" />
		
		<form:label path="confirmarClave">Confirmar Contraseña:</form:label>
		<form:input path="confirmarClave" type="password" />
		<form:errors path="confirmarClave" />
		
		<input type="submit" value="Registrase" />
>>>>>>> patricio
	</form:form>
</body>
</html>