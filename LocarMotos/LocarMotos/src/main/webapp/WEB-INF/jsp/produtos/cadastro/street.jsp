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
        <form action="/street/incluir" method="post">
            <input type="text" class="text" name="Tipo" value="Street">
            <span>Tipo</span>
            <br>
            <input type="text" class="text" name="ano" value="2020">
            <span>Ano</span>
            <br>
            <input type="text" class="text" name="valorVenal" value="15000">
            <span>Valor Venal</span>
            <br>
            <input type="text" class="text" name="precoDiaria" value="10">
            <span>Preco Diaria</span>
            <br>
            <input type="text" class="text" name="cilindradas" value="300">
            <span>cilindradas</span>
            <br>
            <input type="checkbox" name="paraTrabalho" class="custom-checkbox" value="true" checked/>
            <label >Para Trabalho</label>
            <br>
            <input type="checkbox" name="Seguro" class="custom-checkbox" value="true" checked>
            <label >Seguro</label>
            <button class="signin" type="submit">Cadastrar</button>
        </form>
    </div>
</body>