<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="styles.css">
	<title>Cadastrar</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="login">
		<h2 class="nonactive"> Entrar </h2>
		<h2 class="active"> Cadastrar </h2>
		<form action="/cadastro/incluir" method="post">
			<br>
			<input type="nome" class="text" name="nome" value="luiz gustavo">
			<span>Nome</span>
			<br>
			<input type="idade" class="text" name="idade" value="22">
			<span>Email</span>
			<br>
			<input type="text" class="text" name="cnh" value="15555151">
			<span>CNH</span>
			<br>
			<input type="text" class="text" name="cpf" value="155551515">
			<span>CPF</span>
			<br>
			<button class="signin" type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>
