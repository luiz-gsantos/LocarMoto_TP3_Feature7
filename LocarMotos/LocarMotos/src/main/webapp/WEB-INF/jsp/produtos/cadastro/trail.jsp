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
        <h2 class="active"> Cadastrar Produto</h2>
        <form action="/trail/incluir" method="post">
            <input type="text" class="text" name="ano" value="2010">
            <span>Ano</span>
            <br>
            <input type="text" class="text" name="valorVenal" value="23000">
            <span>Valor Venal</span>
            <br>
            <input type="text" class="text" name="precoDiaria" value="15">
            <span>Preço Diaria</span>
            <br>
            <input type="text" class="text" name="peso" value="70">
            <span>Peso</span>
            <br>
            <input type="text" class="text" name="cilindradas" value="300">
            <span>cilindradas</span>
            <br>
            <input type="checkbox" name="seguro" class="custom-checkbox" value="true" checked />
            <label>Seguro</label>
            <br>
            <button class="signin" type="submit">Cadastrar</button>
        </form>
    </div>
</body>