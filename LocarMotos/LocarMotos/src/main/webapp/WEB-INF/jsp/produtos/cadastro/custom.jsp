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
        <form action="/custom/incluir" method="post">
            <input type="text" class="text" name="modelo" value="Fat boy">
            <span>Modelo</span>
            <br>
            <input type="text" class="text" name="marca" value="Harley Davidson">
            <span>Marca</span>
            <br>
            <br>
            <input type="text" class="text" name="ano" value="2015">
            <span>Ano</span>
            <br>
            <input type="text" class="text" name="tipo" value="Custom">
            <span>Tipo</span>
            <br>
            <input type="text" class="text" name="valorVenal" value="55000">
            <span>Valor Venal</span>
            <br>
            <input type="text" class="text" name="precoDiaria" value="30">
            <span>Preço diaria</span>
            <br>
            <input type="text" class="text" name="cilindradas" value="1000">
            <span>cilindradas</span>
            <br>
            <input type="checkbox" name="seguro" class="custom-checkbox" value="true" checked/>
            <label >Seguro</label>
            <br>
            <input type="checkbox" name="aVista" class="custom-checkbox" value="true" checked/>
            <label >A vista</label>
            <button class="signin" type="submit">Cadastrar</button>
        </form>
    </div>
</body>