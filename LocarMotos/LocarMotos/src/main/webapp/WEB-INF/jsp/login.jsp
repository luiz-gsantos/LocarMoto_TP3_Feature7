<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="styles.css">
    <title>Menu</title>
</head>

<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>
<div class="login">
    <h2 class="active"> Entrar </h2>
    <h2 class="nonactive"> Cadastrar </h2>
    <form action="/login" method="post">
        <input type="email" class="text" name="email" value="admin@admin.com">
        <span>Email</span>
        <br>
        <br>
        <input type="password" class="text" name="senha" value="admin@admin.com">
        <span>Senha</span>
        <br>
        <input type="checkbox" id="checkbox-1-1" class="custom-checkbox" />
        <label for="checkbox-1-1">Lembrar dados</label>
        <button class="signin" type="submit">Entrar</button>
        <hr>
        <a href="/usuario">Sem Cadastro?</a>
    </form>
</div>
</body>
</html>
