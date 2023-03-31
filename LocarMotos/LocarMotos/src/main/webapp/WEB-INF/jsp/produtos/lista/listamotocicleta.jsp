<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="styles.css">
    <title>Index</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>
<div class="container-user">
    <h3>Lista de Motocicletas</h3>
    <c:if test="${empty motocicletas}">
        <h5>Não há motocicletas cadastradas.</h5>
    </c:if>
    <c:if test="${not empty motocicletas}">
    <h5>A quantidade de motocicletas cadastradas é: ${motocicletas.size()}!!!</h5>
</div>
<table class="container-table">
    <thead>
    <tr>
        <th>ID</th>
        <th>ano</th>
        <th>valorVenal</th>
        <th>precoDiaria</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="u" items="${motocicletas}">
        <tr>
            <td>${u.id}</td>
            <td>${u.ano}</td>
            <td>${u.valorVenal}</td>
            <td>${u.precoDiaria}</td>
            <td><a href="/motocicleta/{id}/excluir">excluir</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</c:if>
</div>
</body>
</html>
